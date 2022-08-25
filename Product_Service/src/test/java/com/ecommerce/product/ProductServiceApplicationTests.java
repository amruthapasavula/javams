package com.ecommerce.product;

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

import com.ecommerce.product.controller.ProductController;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductServiceRepo;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductServiceRepo productServiceRepo;
	
	@Autowired
	private ProductController pc;
	
	ProductDto p=new ProductDto();
	{
		p.setDescription("product");
		p.setDiscountedPrice(19);
		p.setProductId(1);
		p.setProductName("lap");
		p.setProductRating(4.5f);
		p.setProductReview("nice");
		p.setQuantity(2);
		p.setRegularPrice(2000);
	}
	{
		p.getDescription();
		p.getDiscountedPrice();
		p.getProductId();
		p.getProductName();
		p.getProductRating();
		p.getProductReview();
		p.getQuantity();
		p.getRegularPrice();
	}
	
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
	}
	{
		p1.getDescription();
		p1.getDiscountedPrice();
		p1.getProductId();
		p1.getProductName();
		p1.getProductRating();
		p1.getProductReview();
		p1.getQuantity();
		p1.getRegularPrice();
	}
	@Order(1)
	@Test
	void addProductTest()
	{
		assertEquals("Product saved successfully", productServiceRepo.addProduct(p));
	}
	
	@Order(2)
	@Test
	void getProducts()
	{
		assertEquals(1, productServiceRepo.getProducts().size());
	}
	
	@Order(3)
	@Test
	void getProductById()
	{
		assertEquals(1, productServiceRepo.getProductById(1).getProductId());
	}
	
	@Order(4)
	@Test
	void updatePass()
	{
		assertEquals("no product is found with the product_id you entered...", productServiceRepo.updateProduct(p, 24));
	}
	
	@Order(5)
	@Test
	void updateFail()
	{
		assertEquals("product updated successfully...", productServiceRepo.updateProduct(p, 1));
	}
	
	@Order(6)
	@Test
	void getProductByIdFail()
	{
		assertEquals(null, productServiceRepo.getProductById(5));
	}
	
	@Order(7)
	@Test
	void deleteProduct()
	{
		assertEquals("product deleted successfully", productServiceRepo.deleteProduct(1));
	}
	
	@Order(8)
	@Test
	void saveProducts()
	{
		assertEquals(HttpStatus.OK,pc.saveProducts(p).getStatusCode());
	}
	
	@Order(9)
	@Test
	void getProductsTest()
	{
		assertEquals(1, pc.getProduct().size());
	}
	
	@Order(10)
	@Test
	void getProductByIdTest()
	{
		assertEquals(HttpStatus.NOT_FOUND, pc.getProductById(5).getStatusCode());
	}
	@Order(11)
	@Test
	void getProductByIdTestPass()
	{
		assertEquals(HttpStatus.OK, pc.getProductById(2).getStatusCode());
	}
	
	@Order(12)
	@Test
	void updateProduct()
	{
		assertEquals(HttpStatus.OK, pc.updateProductById(p, 2).getStatusCode());
	}
	
	@Order(13)
	@Test
	void deleteProductTest()
	{
		assertEquals(HttpStatus.OK, pc.deleteProductById(2).getStatusCode());
	}
	@Test
	  public void applicationStarts() {
		ProductServiceApplication.main(new String[] {});
	  }
}
