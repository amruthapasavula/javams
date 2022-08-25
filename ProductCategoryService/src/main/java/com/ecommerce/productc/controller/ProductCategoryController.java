package com.ecommerce.productc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.productc.model.ProductCDto;
import com.ecommerce.productc.model.ProductCategory;
import com.ecommerce.productc.service.ProductCServiceRepo;
import com.ecommerce.productc.vo.ResponseTemplate;

@RestController
@RequestMapping("/productCat")
public class ProductCategoryController {

	@Autowired
	private ProductCServiceRepo pCServiceRepo;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public ProductCategoryController(ProductCServiceRepo pCServiceRepo) {
		super();
		this.pCServiceRepo = pCServiceRepo;
	}

	@PostMapping("/savePc")
	public ResponseEntity<String> saveProductCategory(@RequestBody ProductCDto pCDto)
	{
		
		return new ResponseEntity<>(pCServiceRepo.saveProductCategory(pCDto),HttpStatus.OK);
	}
	
	@GetMapping("/getPc")
	public List<ProductCategory> getAllProductCategories()
	{
		return pCServiceRepo.getAllProductCategories();
	}
	
	
	@PutMapping("/updatePc/{id}")
	public ResponseEntity<String> updateProductCategories(@RequestBody ProductCDto pCDto,@PathVariable int id)
	{
		pCServiceRepo.updateProductCategory(pCDto, id);
		return new ResponseEntity<>("Product Category Updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePc/{id}")
	public ResponseEntity<String> deleteProductCategories(@PathVariable int id)
	{
		pCServiceRepo.deleteProductCategory(id);
		return new ResponseEntity<>("Product Category deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getProductWithCategory/{cId}")
	public ResponseEntity<ResponseTemplate> getProductWithProductCaregory(@PathVariable int cId )
	{
		
		return new ResponseEntity<>(pCServiceRepo.getProductCategoryWithProduct(cId),HttpStatus.OK);
	}
	@GetMapping("pc/{cId}")
	public ResponseEntity<ProductCategory> getProductCategory(@PathVariable int cId)
	{
		return new ResponseEntity<>(pCServiceRepo.getProductCategory(cId),HttpStatus.OK);
	}
	
	
}
