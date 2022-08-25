package com.ecommerce.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.model.CartItemDto;
import com.ecommerce.cart.service.CartServiceRepository;
import com.ecommerce.cart.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartServiceRepository cartServiceRepo;
	
	
	public CartController(CartServiceRepository cartServiceRepo) {
		super();
		this.cartServiceRepo = cartServiceRepo;
	}


	@PostMapping("/add/{cartId}/user/{userId}")
	public ResponseEntity<String> addItemToCart(@PathVariable int cartId,@PathVariable Long userId,@RequestBody CartItemDto cartDto)
	{
		return new ResponseEntity<>(cartServiceRepo.addToCart(cartId, userId, cartDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Cart>> getCart()
	{
		return new ResponseEntity<>(cartServiceRepo.getAllCartItems(),HttpStatus.FOUND);
	}

	@GetMapping("/cart/user/{cartId}")
	public ResponseEntity<ResponseTemplateVO> getCartWithUserDetails(@PathVariable int cartId)
	{
		
		return new ResponseEntity<>(cartServiceRepo.getCartItemsWithUser(cartId),HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{cartId}/cId/{cId}/quantity/{quantity}")
	public ResponseEntity<String> updateQuantity(@PathVariable int cartId,@PathVariable int cId,@PathVariable int quantity)
	{
		
		
		return new ResponseEntity<>(cartServiceRepo.updateQuantityInCart(cartId, cId, quantity),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{cartId}/{cartItemId}")
	public ResponseEntity<String> deleteCartItem(@PathVariable int cartId,@PathVariable int cartItemId)
	{
		
		return new ResponseEntity<>(cartServiceRepo.removeItemFromCart(cartId, cartItemId),HttpStatus.OK);
		
	}
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartItem(@PathVariable int cartId)
	{
		return new ResponseEntity<>(cartServiceRepo.getSingleCart(cartId),HttpStatus.OK);
	}
}

