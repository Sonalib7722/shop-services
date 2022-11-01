package com.as.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.product.model.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

}
