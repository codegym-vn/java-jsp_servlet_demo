package model.services;

import model.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    boolean delete(int id);
}
