package com.ecommerce.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.model.CartItemDto;
import com.ecommerce.cart.model.CartItems;
import com.ecommerce.cart.model.Product;
import com.ecommerce.cart.repository.CartRepository;

import com.ecommerce.cart.vo.ResponseTemplateVO;
import com.ecommerce.cart.vo.User;

@Service
public class CartService implements CartServiceRepository{

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	ResponseTemplateVO response=new ResponseTemplateVO();
	
	Product product;
	Cart c1;
	
	public CartService(CartRepository cartRepository, RestTemplate restTemplate) {
		super();
		this.cartRepository = cartRepository;
		this.restTemplate = restTemplate;
	}



	@Override
	public String addToCart(int cartId,Long userId, CartItemDto cartItemDto) throws NullPointerException{
		
		CartItems var=new CartItems();
		
		Cart var1=new Cart();
		
		var.setCartemId(cartItemDto.getCartItemId());
		
		product=restTemplate.getForObject("http://PRODUCT-SERVICE/product/getProduct/"+cartItemDto.getProductId(), Product.class);
		if(product!=null)
		{
		
		var.setCartemId(cartItemDto.getCartItemId());
		var.setProduct(product);
		var.setPrice(product.getRegularPrice());
		var.setQuantity(cartItemDto.getQuantity());
		var.setDiscount(product.getDiscountedPrice());
		var.setSubTotal(var.getQuantity(), var.getPrice(), var.getDiscount());
		
		var1.setCartId(cartId);
		var1.setUserId(userId);
		var1.addToCart(var);
		var1.getTotalAmount();
		cartRepository.save(var1);
		}
		
		return "Product added to the cart..";
	}
	
	@Override
	public List<Cart> getAllCartItems() {
		
		return cartRepository.findAll();
	}
	
	@Override
	public String removeItemFromCart(int cartId, int cartItemId) {
		
		c1=cartRepository.findById(cartId).orElse(null);
		if(c1!=null)
		{
				
			List<CartItems> cartItems=c1.getCartItems();
			
			List<CartItems> newItems=new ArrayList<>();
			
			for(CartItems item : cartItems)
			{
				if(item.getCartemId() == cartItemId)
				{
					continue;
				}
				newItems.add(item);
			}
			
			c1.setCartItems(newItems);
			cartRepository.save(c1);
		}
			
		return "\"Cart Item Removed Successfully..";
		}
	

	@Override
	public String updateQuantityInCart(int cartId, int cartItemId, int quantity) {

		Optional<Cart> c = cartRepository.findById(cartId);
		if(c.isPresent())
		{

			Cart cart = c.get();
			List<CartItems> cartItems = cart.getCartItems();
			for (CartItems item : cartItems)
			{
				if (item.getCartemId() == cartItemId) {
					item.setQuantity(quantity);
				}

			

			cartRepository.save(cart);
			}
		}

			return "\"quantity updated Successfully..";

		
	}
	
	public Cart getSingleCart(Integer cartId) {

        Optional<Cart> cart = cartRepository.findById(cartId);

        if (cart.isPresent()) {
                      return cart.get();
        } else {
                      return null;
        }

        }

	@Override
	public ResponseTemplateVO getCartItemsWithUser(int cartId) {
		
		Optional<Cart> c = cartRepository.findById(cartId);
		if(c.isPresent())
		{
		Cart var=c.get();
		
		User var1=restTemplate.getForObject("http://USERREGESTRATION-SERVICE/user/id/"+var.getUserId(), User.class);
		
		response.setCart(var);
		response.setUser(var1);
		
		return response;
		}
		else
		{
			return null;
	}
}
	}


