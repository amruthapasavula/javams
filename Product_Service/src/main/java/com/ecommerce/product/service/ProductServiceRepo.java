package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.Product;

public interface ProductServiceRepo {
	
	String addProduct(ProductDto pDto);
	
	List<Product> getProducts();
	
	Product getProductById(int id);
	
	String updateProduct(ProductDto pDto,int id);
	
	String deleteProduct(int id);
	

}

