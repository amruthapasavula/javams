package com.ecommerce.productc.service;

import java.util.List;

import com.ecommerce.productc.model.ProductCDto;
import com.ecommerce.productc.model.ProductCategory;
import com.ecommerce.productc.vo.ResponseTemplate;


public interface ProductCServiceRepo {
	
	String saveProductCategory(ProductCDto pCDto);
	
	List<ProductCategory> getAllProductCategories();

	String updateProductCategory(ProductCDto pCDto, int id);
	
	String deleteProductCategory(int id);
	
	ProductCategory getProductCategory(int id);
	
	ResponseTemplate getProductCategoryWithProduct(int cId);
}
