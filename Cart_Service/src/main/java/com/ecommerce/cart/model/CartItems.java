package com.ecommerce.cart.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CartItems {
	@Id
	private int cartItemId;
	
	private Product product;
	private double price;
	private int discount;
	private int quantity;
	private double subTotal;
	
	public CartItems() {
		super();
	}
	


	public void setSubTotal(int quantity,double price,int discount)
	{
		price=price-discount;
		this.subTotal=quantity*price;
	}
	
	public double getSubTotal()
	{
		return subTotal;
	}

	public int getCartemId() {
		return cartItemId;
	}

	public void setCartemId(int cartemId) {
		this.cartItemId = cartemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
