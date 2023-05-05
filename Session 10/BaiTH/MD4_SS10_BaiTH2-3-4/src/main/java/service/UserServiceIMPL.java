package service;

import config.ConnectionDB;
import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService{
    private String SELECT_ALL_USERS = "SELECT * FROM Users";
    private String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = ConnectionDB.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    // Transaction để thực hiện nhiều nvu, khi xảy ra lỗi có thể rollback lại như chưa từng có cuộc chia ly
    @Override
    public void addUserTransaction(User user, int[] permission) {
        Connection conn = null;
        // for insert a new user
        PreparedStatement pstmt = null;
        // for assign permision to user
        PreparedStatement pstmtAssignment = null;
        // for getting user id
        ResultSet rs = null;
        try {
            conn = ConnectionDB.getConnection();
            // set auto commit to false
            conn.setAutoCommit(false);
            // Insert user
            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            int rowAffected = pstmt.executeUpdate();
            // get user id
            rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next())
                userId = rs.getInt(1);
            // in case the insert operation successes, assign permission to user
            if (rowAffected == 1) {
                // assign permission to user
                String sqlPivot = "INSERT INTO user_permission(User_Id, Permission_Id) " + "VALUES(?,?)";
                pstmtAssignment = conn.prepareStatement(sqlPivot);
                for (int permissionId : permission) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permissionId);
                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (Exception ex) {
            // roll back the transaction
            try {
                if (conn != null)
                    conn.rollback();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (
                Connection conn = ConnectionDB.getConnection();
                Statement statement = conn.createStatement();
                PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
                PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)
                ) {
            // start transaction block

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            conn.setAutoCommit(false);
            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

//            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
            // end transaction block
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
