package com.ecommerce.cart.vo;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.cart.model.CartItems;

public class CartVo {
	private int cartId;
	private List<CartItems> cartItems=new ArrayList<>();
	private double totalAmount;
	private Long userId;
	public CartVo() {
		super();
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
