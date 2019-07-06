package com.tbuk.psd2.model.enums;

public enum Currency {
GBP("GBP"),
USD("USD"),
TRY("TRY"),
EUR("EUR");
	
	String currency;
	Currency(String currency){
		this.currency=currency;
	}
	
	public String getCurrency() {return this.currency;}
}
