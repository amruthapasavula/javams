package com.ecommerce.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.cart.controller.CartController;
import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.model.CartItemDto;
import com.ecommerce.cart.model.CartItems;
import com.ecommerce.cart.model.Product;
import com.ecommerce.cart.service.CartServiceRepository;
import com.ecommerce.cart.vo.CartVo;
import com.ecommerce.cart.vo.ResponseTemplateVO;
import com.ecommerce.cart.vo.User;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class CartEServiceApplicationTests {
	
	@Autowired
	private CartServiceRepository cartService;
	
	@Autowired
	private CartController cartController;
	
	
	
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

	CartItems cartItems=new CartItems();
	
	List<CartItems> cartList=new ArrayList<CartItems>();
	{
		cartItems.setCartemId(1);
		cartItems.setDiscount(20);
		cartItems.setPrice(2000);
		cartItems.setProduct(p1);
		cartItems.setQuantity(1);
		cartItems.setSubTotal(cartItems.getQuantity(), cartItems.getPrice(), cartItems.getDiscount());
		cartItems.getCartemId();cartItems.getProduct();cartItems.getSubTotal();
	}
	User uDto=new User();
	{
		uDto.setAddress("mp");
		uDto.setEmail("maya@gmail.com");
		uDto.setFname("maya");
		uDto.setLname("sree");
		uDto.setMobileno("9764933832");
		uDto.setPassword("maya123");
		uDto.setUserId(3L);
		uDto.getAddress();uDto.getEmail();uDto.getFname();uDto.getLname();uDto.getMobileno();uDto.getPassword();uDto.getUserId();
	}
	CartVo cart=new CartVo();
	{
		cart.setCartId(1);
		cart.setCartItems(cartList);
		cart.setTotalAmount(200);
		cart.setUserId(3L);
		cart.getCartId();cart.getCartItems();cart.getTotalAmount();cart.getUserId();
	}
	
	Cart c=new Cart();
	{
		c.setCartId(1);
		c.setCartItems(cartList);
		c.setUserId(3L);
		c.getUserId();c.getCartId();c.getCartItems();c.getTotalAmount();
	}
	
	CartItemDto cartDto=new CartItemDto();
	
	{
		cartDto.setCartItemId(1);
		cartDto.setProductId(1);
		cartDto.setQuantity(1);
		cartDto.getCartItemId();cartDto.getProductId();cartDto.getQuantity();
	}
	
	{
		ResponseTemplateVO response=new ResponseTemplateVO();
		{
			response.setUser(uDto);
			response.getUser();
			response.setCart(c);
		}
	}
	@Test
	   void applicationStarts() {
		CartEServiceApplication.main(new String[] {});
	  }
	@Order(1)
	@Test
	void addToCartTest()
	{
		assertEquals("Product added to the cart..", cartService.addToCart(1, 3L, cartDto));
	}
	@Order(2)
	@Test
	void getAllCartItemsTest()
	{
		assertEquals(3, cartService.getAllCartItems().size());
	}
	
	@Order(4)
	@Test
	void removeItemFromCartPass()
	{
		assertEquals("\"Cart Item Removed Successfully..", cartService.removeItemFromCart(1, 1));
	}
	@Order(5)
	@Test
	void updateQuantityInCartTest()
	{
		assertEquals("\"quantity updated Successfully..", cartService.updateQuantityInCart(1, 1, 3));
	}
	
	@Order(5)
	@Test
	void getSingleCartTest()
	{
		assertEquals(1, cartService.getSingleCart(1).getCartId());
	}
	
	@Order(6)
	@Test
	void getSingleCartTestFail()
	{
		assertEquals(null, cartService.getSingleCart(9));
	}
	@Order(6)
	@Test
	void getCartItemsWithUser()
	{
		assertEquals(1, cartService.getCartItemsWithUser(1).getCart().getCartId());
	}
	
	//controller
	@Order(7)
	@Test
	void addItemToCart()
	{
		assertEquals(HttpStatus.CREATED, cartController.addItemToCart(1, 3L, cartDto).getStatusCode());
	}
	
	@Order(8)
	@Test
	void getCart()
	{
		assertEquals(HttpStatus.FOUND, cartController.getCart().getStatusCode());
	}
	
	@Order(9)
	@Test
	void getCartWithUserDetails() {
		assertEquals(HttpStatus.OK, cartController.getCartWithUserDetails(1).getStatusCode());
	}
	
//	@Order(9)
//	@Test
//	void updateQuantityFail()
//	{
//		assertEquals(HttpStatus.NOT_FOUND, cartController.updateQuantity(5, 19, 2).getStatusCode());
//	}

	@Order(10)
	@Test
	void updateQuantityPass()
	{
		assertEquals(HttpStatus.OK, cartController.updateQuantity(1, 1, 2).getStatusCode());
	}
	
//	@Order(10)
//	@Test
//	void deleteCartItem()
//	{
//		assertEquals(HttpStatus.NOT_FOUND, cartController.deleteCartItem(5, 8).getStatusCode());
//	}
//	
	@Order(10)
	@Test
	void deleteCartItemPass()
	{
		assertEquals(HttpStatus.OK, cartController.deleteCartItem(1, 1).getStatusCode());
	}
	@Order(10)
	@Test
	void getCartItem()
	{
		assertEquals(HttpStatus.OK, cartController.getCartItem(1).getStatusCode());
	}
}
