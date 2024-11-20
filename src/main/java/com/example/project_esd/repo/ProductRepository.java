package com.example.project_esd.repo;

import com.example.project_esd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE price BETWEEN 15 AND 30 ORDER BY price ASC LIMIT 2", nativeQuery = true)
    List<Product> findTop2ProductPriceRange();
}