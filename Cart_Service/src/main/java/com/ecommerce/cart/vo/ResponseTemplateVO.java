package com.ecommerce.cart.vo;

import com.ecommerce.cart.model.Cart;

public class ResponseTemplateVO {
	
	User user;
	Cart cart;
	
	public ResponseTemplateVO() {
		super();
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

	
}
