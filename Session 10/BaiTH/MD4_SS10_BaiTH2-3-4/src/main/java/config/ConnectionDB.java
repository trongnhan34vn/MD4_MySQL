package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
     private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
     private static final String URL = "jdbc:mysql://localhost:3306/demo_SS10_BaiTH2";
     private static final String USER = "root";
     private static final String PASSWORD = "Nhantic1998@";

     public static Connection getConnection() {
         Connection conn = null;
         try {
             Class.forName(DRIVER);
             conn = DriverManager.getConnection(URL,USER,PASSWORD);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return conn;
     }

    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println("Connection ------> " + conn);
    }
}
