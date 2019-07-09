package com.tbuk.psd2.util;

import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.request.PaymentInitiationRequest;

public class DummyRequests {

	public static PaymentInitiationRequest domesticPayment() {
		
		return PaymentInitiationRequest.builder()
				.debtor(debtor1())
				.build();
		
	}
	
	public static BankAccount debtor1() {
	 return	BankAccount.builder()
		      .accountId("1")
		      .accountNo("12345678")
		      .build();
	}
}
