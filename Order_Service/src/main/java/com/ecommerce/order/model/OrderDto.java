package com.ecommerce.order.model;

import java.util.Date;

public class OrderDto {
	private int cartId;
	private int userId;
	private Address shippingAddress;
	private Payment paymentMethods;
	private Card cardDetails;
	private Date orderDate=new Date();
	
	public OrderDto() {
		super();
	}
	
	
	
	public Integer getCartId() {
		return cartId;
	}
	
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Address getShippingAddress() {
		return shippingAddress;
	}
	
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public Payment getPaymentMethods() {
		return paymentMethods;
	}
	
	public void setPaymentMethods(Payment paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
	public Card getCardDetails() {
		return cardDetails;
	}
	
	public void setCardDetails(Card cardDetails) {
		this.cardDetails = cardDetails;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

}
