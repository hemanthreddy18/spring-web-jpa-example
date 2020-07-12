package com.learning.spring.workshop.service;

import com.learning.spring.workshop.dao.ProductDao;
import com.learning.spring.workshop.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product entity = productDao.findById(product.getId());
        if (entity != null) {
            entity.setId(product.getId());
            entity.setName(product.getName());
            entity.setProductType(product.getProductType());
            entity.setManfast(product.getManfast());
        }
    }

    @Override
    public void deleteProductById(int id) {
        productDao.removeProductById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.getAllProducts();
    }
}
