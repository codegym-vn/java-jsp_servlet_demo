package model.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDb {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductManagement", "root", "123456");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}