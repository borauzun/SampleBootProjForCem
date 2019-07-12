package com.tbuk.psd2.model.enums;

public enum PaymentType {
	
	TRANSFERBETWEENOWNACCOUNTS("TRANSFERTBUK"),
	FASTER_PAYMENT_TRANSFER("FPS"),
	INTERNATIONAL("INTERNATIONAL");
		
		String paymentType;
		PaymentType(String paymentType){
			this.paymentType=paymentType;
		}
		public String getPaymentType() {
			return this.paymentType;
		}


}
