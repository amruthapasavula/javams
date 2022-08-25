package com.ecommerce.order.service;

import java.util.List;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderDto;

public interface OrderServiceRepository  {
	
	Order makeAnOrder(OrderDto order);
	
	List<Order> getOrderByUserId(Integer userId);
	
	Order getSingleOrder(String orderId);
	
}

