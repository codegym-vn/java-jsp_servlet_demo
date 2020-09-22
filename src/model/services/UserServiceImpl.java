package model.services;

import model.dataAccessLayer.ConnectDb;
import model.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {

    public boolean login(String userName, String password) {
        boolean isLogined = false;
       try{
           Connection conn = ConnectDb.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("select * from user");
           while (rs.next()) {
               String name = rs.getString(2);
               String pass = rs.getString(4);
               if (name.equals(userName) && pass.equals(password)) {
                   isLogined = true;
               }
           }
           conn.close();
       }catch (Exception ex){
           System.out.println(ex);
       }
        return isLogined;
    }
}
