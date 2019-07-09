package com.tbuk.psd2.model.response;

import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.enums.TransactionStatus;
import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.payment.PaymentInfo;

public class PaymentResult {
	
	String requestId;
	BankAccount debtor;
	BankAccount creditor;
	PaymentInfo paymentInfo;
	TransactionStatus status;
	Error error;
}
