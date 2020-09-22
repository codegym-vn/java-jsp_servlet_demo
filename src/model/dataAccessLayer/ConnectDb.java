package model.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/ProductManagement";
        String username = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}