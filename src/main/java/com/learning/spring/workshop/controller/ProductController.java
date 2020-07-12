package com.learning.spring.workshop.controller;

import com.learning.spring.workshop.dto.ItemDto;
import com.learning.spring.workshop.dto.ManifacturerDto;
import com.learning.spring.workshop.dto.ProductDto;
import com.learning.spring.workshop.model.Manfast;
import com.learning.spring.workshop.model.Product;
import com.learning.spring.workshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> listProducts() {
        List<Product> products = productService.findAllProducts();
        System.out.println("Products:"+products);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: products) {
            productDtos.add(buildProductDto(product));
        }
        return productDtos;
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") int id) {
        Product product = productService.findById(id);
        return buildProductDto(product);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable("id") int id) {
        productService.deleteProductById(id);
    }

    private ProductDto buildProductDto(Product itemProduct){
        Manfast manfast = itemProduct.getManfast();
        ManifacturerDto manifacturer = ManifacturerDto.builder()
                .id(manfast.getId())
                .name(manfast.getName())
                .build();
        return ProductDto.builder()
                .id(itemProduct.getId())
                .name(itemProduct.getName())
                .manifacturer(manifacturer)
                .build();
    }
}
