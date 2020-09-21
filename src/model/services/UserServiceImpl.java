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
    @Override
    public List<User> findAll() {
        ArrayList<User> studentList = new ArrayList<>();
        studentList.add(new User("R001", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new User("R002", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new User("R003", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new User("R004", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        studentList.add(new User("R005", "A", "a@gmail.com", "1999-01-01", "Ha Noi"));
        return studentList;
    }

    @Override
    public void save(User customer) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void update(int id, User customer) {

    }

    @Override
    public void remove(int id) {

    }
}
