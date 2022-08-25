package com.ecommerce.productc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.productc.model.ProductCategory;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
