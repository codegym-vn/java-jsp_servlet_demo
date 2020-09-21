package model.services;


import model.dataAccessLayer.ConnectDb;
import model.entities.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Connection conn = ConnectDb.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Product");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                int categoryId = rs.getInt(4);
                products.add(new Product(id,name,price,categoryId));
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return products;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        Connection conn = ConnectDb.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("delete * from Product where id="+id);
            isDelete = true;
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return isDelete;
    }
}
