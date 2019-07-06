package com.tbuk.psd2.model.enums;

public enum PaymentType {
	
	DOMESTIC("DOMESTIC"),
	INTERNATIONAL("INTERNATIONAL");
		
		String paymentType;
		PaymentType(String transactionType){
			this.paymentType=transactionType;
		}
		public String getPaymentType() {
			return this.paymentType;
		}

}
