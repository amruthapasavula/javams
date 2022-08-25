package com.ecommerce.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.order.model.Cart;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderDto;
import com.ecommerce.order.model.User;
import com.ecommerce.order.repository.OrderRepository;
@Service
public class OrderService implements OrderServiceRepository {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public OrderService(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}
	
	@Override
	public Order makeAnOrder(OrderDto order) {
		Cart cart=restTemplate.getForObject("http://CART-SERVICE/cart/"+order.getCartId(), Cart.class);
		
		User user=restTemplate.getForObject("http://USERREGESTRATION-SERVICE/user/id/"+order.getUserId(),User.class);
				
		Order o=new Order();
		
		o.setCard(order.getCardDetails());
		o.setCart(cart);
		o.setPaymentMode(order.getPaymentMethods());
		o.setShippingAddress(order.getShippingAddress());
		o.setUser(user);
		o.setOrderId( order.getOrderDate());
		
		return orderRepo.save(o);
		
	}
	
	public List<Order> getOrderByUserId(Integer userId) {

		return orderRepo.findByUserUserId(userId);
		
	}
	
	public Order getSingleOrder(String orderId) {
		Optional<Order> order = orderRepo.findById(orderId);
		if(order.isPresent()) {
			return order.get();
		}else {
			throw new RuntimeException("order not found");
		}
	}
	

}
