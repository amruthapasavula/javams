package com.ecommerce.productc.vo;

import com.ecommerce.productc.model.Product;
import com.ecommerce.productc.model.ProductCategory;

public class ResponseTemplate {
	Product product;
	ProductCategory pc;
	
	public ResponseTemplate() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductCategory getPc() {
		return pc;
	}
	public void setPc(ProductCategory pc) {
		this.pc = pc;
	}
	
	

}
