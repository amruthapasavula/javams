package com.ecommerce.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderDto;
import com.ecommerce.order.service.OrderServiceRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceRepository orderServiceRepo;
	
	
	
	
	public OrderController(OrderServiceRepository orderServiceRepo) {
		super();
		this.orderServiceRepo = orderServiceRepo;
	
	}



	@PostMapping("/")
	public ResponseEntity<Order> makeOrder(@RequestBody OrderDto orderDto)
	{
		return new ResponseEntity<>(orderServiceRepo.makeAnOrder(orderDto),HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrders(@PathVariable String orderId)
	{
		return new ResponseEntity<>(orderServiceRepo.getSingleOrder( orderId),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Integer userId) {

		List<Order> orders=orderServiceRepo.getOrderByUserId(userId);
		return new ResponseEntity<>(orders,HttpStatus.FOUND);
	

	}
	

}
