package com.ecommerce.cart.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Cart {
	@Id
	private int cartId;
	private List<CartItems> cartItems=new ArrayList<>();
	private double totalAmount;
	private Long userId;
	private int deliveryCharges;
	
	public Cart() {
		super();
	}
	
	public double getTotalAmount()
	{
		totalAmount=0d;
	
	 List<CartItems> cartItems= getCartItems() ;
	 
	 for(CartItems item:cartItems)
	 {
		 this.totalAmount=totalAmount+item.getSubTotal();
	 }
	 return totalAmount+deliveryCharges;
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

	public void setCartItems(List<CartItems> newItems) {
		this.cartItems = newItems;
		getTotalAmount();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean addToCart(CartItems item) {

		return this.cartItems.add(item);

	}
	
	
}


