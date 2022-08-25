package com.ecommerce.order.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Order {
	@Id
	private String orderId;
	private Date orderDate=new Date();
	private double totalPrice;
	private User user;
	private Cart cart;
	private Address shippingAddress;
	private Payment paymentMode;
	private Card card;
	
	public Order() {
		super();
	}
	
	public void setOrderId(Date orderDate)
	{
		SimpleDateFormat var=new SimpleDateFormat("yyyyMMDD120000.SSSSSSSS");
		this.orderId="B2C.Co001."+var.format(orderDate);
	}
	
	public String getOrderId()
	{
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Payment getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Payment paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	
}
