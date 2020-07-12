package com.learning.spring.workshop.service;

import com.learning.spring.workshop.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(int id);
    List<Product> findAllProducts();
}
