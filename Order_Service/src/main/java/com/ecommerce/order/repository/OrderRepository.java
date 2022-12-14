package com.ecommerce.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.order.model.Order;
@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
	List<Order> findByUserUserId(int userId);
}
