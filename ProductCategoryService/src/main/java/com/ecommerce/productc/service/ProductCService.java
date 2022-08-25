package com.ecommerce.productc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.productc.model.Product;
import com.ecommerce.productc.model.ProductCDto;
import com.ecommerce.productc.model.ProductCategory;
import com.ecommerce.productc.repository.ProductCategoryRepository;
import com.ecommerce.productc.vo.ResponseTemplate;


@Service
public class ProductCService implements ProductCServiceRepo{
	
	@Autowired
	private ProductCategoryRepository pCRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ProductCService(ProductCategoryRepository pCRepo) {
		super();
		this.pCRepo = pCRepo;
	}

	@Override
	public String saveProductCategory(ProductCDto pCDto) {
		
		
		ProductCategory pc=new ProductCategory();
		BeanUtils.copyProperties(pCDto, pc);
		pCRepo.save(pc);
		return "product category added successfully";
		
	}
	
	@Override
	public List<ProductCategory> getAllProductCategories() {
		return pCRepo.findAll();
	}
	
	@Override
	public String deleteProductCategory(int pcId) {
		pCRepo.deleteById(pcId);
		return "Product Category deleted Successfully...";
	}
	
	@Override
	public String updateProductCategory(ProductCDto pCDto, int id) {
		
		Optional<ProductCategory> pcOptional=pCRepo.findById(id);
		if(pcOptional.isPresent())
		{		
			ProductCategory pc=new ProductCategory();
		pc.setCategoryId(pCDto.getCategoryId());
		pc.setCategoryName(pCDto.getCategoryName());
		pc.setCreatedOn(pCDto.getCreatedOn());
		pc.setProductId(pCDto.getProductId());
		pCRepo.save(pc);
		return "product Category updated ";
		}
		else
		{
			return "product category not found";
		}
		
		
	}

	@Override
	public ProductCategory getProductCategory(int id) {

		return pCRepo.findById(id).orElse(null);
	}
	
	public ResponseTemplate getProductCategoryWithProduct(int cId)
	{
	ResponseTemplate responseTemp=new ResponseTemplate();
	
	Optional<ProductCategory> productCategoryOptional= pCRepo.findById(cId);
	
	if(productCategoryOptional.isPresent())
	{
		ProductCategory productCategory=productCategoryOptional.get();
	
	ProductCDto productDto=new ProductCDto();
	
	BeanUtils.copyProperties(productCategory, productDto);
	
	Product p=restTemplate.getForObject("http://PRODUCT-SERVICE/product/getProduct/"+productCategory.getProductId(), Product.class);
	
	responseTemp.setPc(productCategory);
	responseTemp.setProduct(p);
	
	return responseTemp;
	}
	else
		return null;
	}
	
}
