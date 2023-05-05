package service;

import config.ConnectionDB;
import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService{

    @Override
    public List<User> findAll() {
        List<User> listUsers = new ArrayList<>();
        String query = "{CALL get_all_user()}";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callableStatement = conn.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setName(resultSet.getString("Name"));
                user.setEmail(resultSet.getString("Email"));
                user.setCountry(resultSet.getString("Country"));
                listUsers.add(user);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    @Override
    public User findById(int id) {
        for (User user:findAll()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {
        if(findById(user.getId()) != null) {
            updateUser(user);
        }
    }

    private void updateUser(User user) {
        String query = "{CALL update_user(?, ?, ?, ?)}";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callableStatement = conn.prepareCall(query);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        String query = "{CALL delete_user(?)}";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);
            CallableStatement callableStatement = conn.prepareCall(query);
            callableStatement.setInt(2, id);
            callableStatement.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
