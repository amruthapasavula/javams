package com.ecommerce.product.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceRepo{
	
	@Autowired
	private ProductRepository pRepo;

	public ProductService(ProductRepository pRepo) {
		super();
		this.pRepo = pRepo;
	}
	
	@Override
	public String addProduct(ProductDto pDto) {
		
		Product p=new Product();
		BeanUtils.copyProperties(pDto, p);
		pRepo.save(p);
		return "Product saved successfully";
	}
	@Override
	public List<Product> getProducts() {
		return pRepo.findAll();
	}
	
	@Override
	public Product getProductById(int id) {
		return pRepo.findById(id).orElse(null);
	}
	
	@Override
	public String deleteProduct(int id) {
		pRepo.deleteById(id);
		return "product deleted successfully";
	}
	
	@Override
	public String updateProduct(ProductDto pDto, int id) {
		Product product=pRepo.findById(id).orElse(null);
		if(product==null)
		{
			return "no product is found with the product_id you entered...";
		}
		else
		{
			//product.setProductId(pDto.getProductId());
			product.setDescription(pDto.getDescription());
			product.setDiscountedPrice(pDto.getDiscountedPrice());
			product.setProductName(pDto.getProductName());
			product.setProductRating(pDto.getProductRating());
			product.setProductReview(pDto.getProductReview());
			product.setQuantity(pDto.getQuantity());
			product.setRegularPrice(pDto.getRegularPrice());
			pRepo.save(product);
			
			return "product updated successfully...";
		}
	}

}
