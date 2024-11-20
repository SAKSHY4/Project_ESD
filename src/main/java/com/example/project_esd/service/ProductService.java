package com.example.project_esd.service;

import com.example.project_esd.entity.Product;
import com.example.project_esd.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Create
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    //Read
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id); // Returns Optional<Product>
    }

    //Delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //Update
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Custom query
    public List<Product> getTop2ProductPriceRange() {
        return productRepository.findTop2ProductPriceRange();
    }

}
