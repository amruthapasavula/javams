package com.ecommerce.cart.service;

import java.util.List;

import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.model.CartItemDto;
import com.ecommerce.cart.vo.ResponseTemplateVO;

public interface CartServiceRepository {
	
	String addToCart(int cartId,Long userId,CartItemDto cartItemDto);
	
	String updateQuantityInCart(int cartId,int cartItemId,int quantity);
	
	String removeItemFromCart(int cartId,int cartItemId);
	
	List<Cart> getAllCartItems();
	
	ResponseTemplateVO getCartItemsWithUser(int cartId);
	
	Cart getSingleCart(Integer cartId);

}
