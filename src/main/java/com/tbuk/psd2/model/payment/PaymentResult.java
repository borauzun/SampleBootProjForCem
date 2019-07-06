package com.tbuk.psd2.model.payment;

import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.enums.PaymentStatus;
import com.tbuk.psd2.model.enums.TransactionStatus;

public class PaymentResult {
	
	String requestId;
	BankAccount debtor;
	BankAccount creditor;
	PaymentInfo paymentInfo;
	TransactionStatus status;
	Error error;
}
