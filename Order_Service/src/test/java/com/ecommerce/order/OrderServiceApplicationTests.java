package com.ecommerce.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.order.controller.OrderController;
import com.ecommerce.order.model.Address;
import com.ecommerce.order.model.Card;
import com.ecommerce.order.model.Cart;
import com.ecommerce.order.model.CartItems;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderDto;
import com.ecommerce.order.model.Payment;
import com.ecommerce.order.model.Product;
import com.ecommerce.order.model.User;
import com.ecommerce.order.service.OrderServiceRepository;


@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceApplicationTests {
	
	Date date=new Date(2021-2-9);
	User user=new User();
	{
		user.setAddress("ap");
		user.setEmail("ram@gmail.com");
		user.setFname("ram");
		user.setLname("krishna");
		user.setMobileno("9783498347");
		user.setPassword("rk123");
		user.setUserId(1L);
		user.getAddress();user.getEmail();user.getFname();user.getLname();user.getMobileno();user.getPassword();user.getUserId();
	}
	
	Address address=new Address();
	{
		address.setCity("Guntakal");
		address.setCountry("india");
		address.setDistrict("anantapur");
		address.setLine1("BCColony");
		address.setState("ap");
		address.setZipcode(515812);
		address.getCity();address.getCountry();address.getDistrict();address.getLine1();address.getState();address.getZipcode();
	}
	
	Card card=new Card();
	{
		card.setCardNumber("9000 4563 7628 8765");
		card.setCvv(347);
		card.setExpireCardDate("10/25");
		card.setName("PAsavula Amrutha");
		card.getCardNumber();card.getCvv();card.getExpireCardDate();card.getName();
	}
	Payment payment;
	
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
	Cart c=new Cart();
	{
		c.setCartId(1);
		c.setCartItems(cartList);
		c.setUserId(3L);
		c.getUserId();c.getCartId();c.getCartItems();c.getTotalAmount();
	}
	
	Order order=new Order();
	{
		order.setCard(card);
		order.setCart(c);
		order.setOrderDate(date);
		order.getCard();order.getCart();order.getOrderDate();order.getOrderId();order.getPaymentMode();order.getShippingAddress();order.getTotalPrice();order.getUser();
	}
	OrderDto orderDto=new OrderDto();
	{
		orderDto.setCardDetails(card);
		orderDto.setCartId(1);
		orderDto.setOrderDate(date);
		orderDto.setPaymentMethods(payment);
		orderDto.setShippingAddress(address);
		orderDto.setUserId(3);
		orderDto.getCardDetails();orderDto.getCartId();orderDto.getOrderDate();orderDto.getPaymentMethods();
		orderDto.getShippingAddress();orderDto.getUserId();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	OrderServiceRepository orderServiceRepo;
	
	@Autowired
	OrderController orderController;
	
	@Test
	   void applicationStarts() {
		OrderServiceApplication.main(new String[] {});
	  }
	
	@Test
	void  makeAnOrderTest()
	{
		assertEquals(3L, orderServiceRepo.makeAnOrder(orderDto).getUser().getUserId());
	}

	@Test
	void getOrders()
	{
		assertEquals(1, orderServiceRepo.getOrderByUserId(3).size());
	}
	
	@Test
	void getSingleOrder()
	{
		assertEquals(1L	, orderServiceRepo.getSingleOrder("B2C.do001.202208214120000.00000852").getUser().getUserId());
	}
	@Test
	void getSingleOrderFail()
	{
		assertThrows(RuntimeException.class, () ->orderServiceRepo.getSingleOrder("B2C."),"order not found");
	}
	
	@Test
	void  makeAnOrderTestPass()
	{
		assertEquals(HttpStatus.OK, orderController.makeOrder(orderDto).getStatusCode());
	}

	@Test
	void getOrdersPass()
	{
		assertEquals(HttpStatus.FOUND, orderController.getOrdersByUserId(3).getStatusCode());
	}
	
	@Test
	void getSingleOrderPass()
	{
		assertEquals(HttpStatus.OK	, orderController.getOrders("B2C.do001.202208214120000.00000852").getStatusCode());
	}
}
