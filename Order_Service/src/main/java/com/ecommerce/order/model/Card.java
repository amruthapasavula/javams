package com.ecommerce.order.model;

public class Card {
	private String cardNumber;
	
	private int cvv;
	
	private String name;
	
	private String expireCardDate;

	public Card() {
		super();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpireCardDate() {
		return expireCardDate;
	}

	public void setExpireCardDate(String expireCardDate) {
		this.expireCardDate = expireCardDate;
	}
	
	
}
