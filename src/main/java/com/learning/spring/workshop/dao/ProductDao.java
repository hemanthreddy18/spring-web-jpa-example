package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(int id);
    void addProduct(Product product);
    void removeProductById(int id);
    List<Product> getAllProducts();
}
