package com.tbuk.psd2.model.enums;

public enum TransactionType {
   DEBIT("DEBIT"),
   CREDIT("CREDIT");
	
	String transactionType;
	TransactionType(String transactionType){
		this.transactionType=transactionType;
	}
	public String getTransactionType() {
		return this.transactionType;
	}
}
