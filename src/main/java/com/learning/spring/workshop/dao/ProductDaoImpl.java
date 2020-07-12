package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractDao<String, Product> implements ProductDao{

    @Override
    public Product findById(int id) {
        return getByKey(id);
    }

    @Override
    public void addProduct(Product product) {
        persist(product);
    }

    @Override
    public void removeProductById(int id) {
        Product product = getByKey(id);
        if (product != null) {
            delete(product);
        } else {
            System.out.println("Product not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List productList = getEntityManager()
                .createQuery("Select p from Product p Join FETCH p.manfast Order By p.name ASC")
                .getResultList();
        return productList;
    }
}
