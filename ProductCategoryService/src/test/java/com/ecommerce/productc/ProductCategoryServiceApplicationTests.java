package com.ecommerce.productc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.productc.controller.ProductCategoryController;
import com.ecommerce.productc.model.Product;
import com.ecommerce.productc.model.ProductCDto;
import com.ecommerce.productc.model.ProductCategory;
import com.ecommerce.productc.service.ProductCServiceRepo;


@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryServiceApplicationTests {

	@Autowired
	private ProductCServiceRepo pcService;
	
	@Autowired
	private ProductCategoryController pcController;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Product p1=new Product();
	{
		p1.setDescription("product");
		p1.setDiscountedPrice(19);
		p1.setProductId(1);
		p1.setProductName("mobile");
		p1.setProductRating(4.5f);
		p1.setProductReview("nice");
		p1.setQuantity(2);
		p1.setRegularPrice(2000);
		p1.getDescription();p1.getDiscountedPrice();p1.getDiscountedPrice();p1.getProductId();p1.getProductName();
		p1.getProductRating();p1.getProductReview();p1.getQuantity();p1.getRegularPrice();
	}
	
	ProductCategory pc=new ProductCategory();
	{
		pc.setCategoryId(1);
		pc.setCategoryName("electronic");
		pc.setCreatedOn(null);
		pc.setProductId(1);
		pc.getCategoryId();pc.getCategoryName();pc.getCreatedOn();pc.getProductId();
	}

	ProductCDto pcd=new ProductCDto();
	{
		pcd.setCategoryId(1);
		pcd.setCategoryName("tv");
		pcd.setCreatedOn(null);
		pcd.setProductId(1);
		
		pcd.getCategoryId();pcd.getCategoryName();pcd.getCreatedOn();pcd.getProductId();
	}
	@Order(1)
	@Test
	void addProductCategory() {
		assertEquals("product category added successfully", pcService.saveProductCategory(pcd));
	}
	@Order(2)
	@Test
	void getProductCategories()
	{
		assertEquals(1, pcService.getAllProductCategories().size());
	}
	
	@Order(3)
	@Test
	void updateProductCategory()
	{
		assertEquals("product Category updated ", pcService.updateProductCategory(pcd, 1));
	}
	
	@Order(4)
	@Test
	void updateProductCategoryFail()
	{
		assertEquals("product category not found", pcService.updateProductCategory(pcd, 6));
	}
	
	@Order(5)
	@Test
	void getProductCategory()
	{
		assertEquals(1, pcService.getProductCategory(1).getCategoryId());
	}
	
	@Order(6)
	@Test
	void getProductCategoryFail()
	{
		assertEquals(null, pcService.getProductCategory(8));
	}
	
	
	
	@Order(7)
	@Test
	void getProductCategoryWithProduct()
	{
		pcService.getProductCategoryWithProduct(1).getProduct();
		assertEquals(1, pcService.getProductCategoryWithProduct(1).getPc().getCategoryId());
	}
	
	@Order(7)
	@Test
	void getProductCategoryWithProductTestFail()
	{
		assertEquals(null, pcService.getProductCategoryWithProduct(14));
	}
	
	@Order(8)
	@Test
	void deleteProduct()
	{
		assertEquals("Product Category deleted Successfully...", pcService.deleteProductCategory(1));
	}
	
	@Order(9)
	@Test
	void saveProductCategoryTest()
	{
		assertEquals(HttpStatus.OK	, pcController.saveProductCategory(pcd).getStatusCode());
	}
	
	@Order(10)
	@Test
	void getProductCategoriesTest()
	{
		assertEquals(1, pcController.getAllProductCategories().size());
	}
	
	@Order(11)
	@Test
	void updateProductCategoryTest()
	{
		assertEquals(HttpStatus.OK, pcController.updateProductCategories(pcd, 2).getStatusCode());
	}
	
	@Order(12)
	@Test
	void getProductCategoryTest()
	{
		assertEquals(HttpStatus.OK, pcController.getProductCategory(2).getStatusCode());
	}
	@Order(13)
	@Test
	void getProductCategoryWithProductTest()
	{
		assertEquals(HttpStatus.OK, pcController.getProductWithProductCaregory(2).getStatusCode());
	}
	
	@Order(14)
	@Test
	void deleteProductTest()
	{
		assertEquals(HttpStatus.OK, pcController.deleteProductCategories(2).getStatusCode());
	}
	@Test
	   void applicationStarts() {
		ProductCategoryServiceApplication.main(new String[] {});
	  }
}
