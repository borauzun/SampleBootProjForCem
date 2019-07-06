package com.tbuk.psd2.model.enums;

public enum PaymentStatus {
	INPROCESS("ACCEPTED"),
	ACCEPTED("ACCEPTED"),
	REJECTEDBYCREDITORAGENT("REJECTED"),
	REJECTEDBYTBUK("REJECTED");
	
	String paymentStatus;
	PaymentStatus(String status){
		this.paymentStatus=status;
	}
	
	public String getStatus() {return this.paymentStatus;}

}
