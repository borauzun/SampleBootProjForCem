package com.tbuk.psd2.model.enums;

public enum TransactionType {
   FPSTRANSFER("FPS"),
   SEPATRANSFER("SEPA"),
   SWIFTTRANSFER("SWIFT"),
   PAYMENT("PAYMENT"),
   CHARGES("CHARGES"),
   ONLINEPAYMENT("ONLINEPAYMENT");
	
	String transactionType;
	TransactionType(String transactionType){
		this.transactionType=transactionType;
	}
	public String getTransactionType() {
		return this.transactionType;
	}
}
