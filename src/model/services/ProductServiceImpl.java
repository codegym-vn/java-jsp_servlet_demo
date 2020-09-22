package model.services;


import model.dataAccessLayer.ConnectDb;
import model.entities.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = ConnectDb.getConnection();
            String query = "{CALL sp_getAllProduct()}";
            CallableStatement stmt = conn.prepareCall(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                int categoryId = rs.getInt(4);
                products.add(new Product(id, name, price, categoryId));
            }
            conn.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return products;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            Connection conn = ConnectDb.getConnection();
            String query = "{CALL sp_removeProduct(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return rowDeleted;
    }

    @Override
    public boolean create(Product p) {
        boolean isAdded = false;
        String sqlQuery = "INSERT INTO product" + "(id,_name,price,catId) VALUES " + "(?, ?, ? ,?);";
        try {
            Connection connection = ConnectDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setString(2, p.getName());
            preparedStatement.setFloat(3, p.getPrice());
            preparedStatement.setFloat(4, p.getCategoryId());
            isAdded = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateUser(Product p) {
        final String UPDATE_QUERY = "update product set name = ?,price= ?, categoryId =? where id = ?;";
        boolean rowUpdated = false;
        try {
            Connection connection = ConnectDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, p.getName());
            statement.setFloat(2, p.getPrice());
            statement.setInt(3, p.getCategoryId());
            statement.setInt(4, p.getId());
            rowUpdated = statement.executeUpdate() > 0;
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return rowUpdated;
    }

}
