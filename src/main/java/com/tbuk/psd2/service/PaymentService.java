package com.tbuk.psd2.service;

import com.tbuk.psd2.model.enums.Currency;
import com.tbuk.psd2.model.enums.TransactionStatus;
import com.tbuk.psd2.model.payment.PaymentInfo;
import com.tbuk.psd2.model.request.PaymentInitiationRequest;
import org.springframework.stereotype.Service;

import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.response.payment.PaymentResult;

@Service
public class PaymentService {
	
	// Generic

	public PaymentResult paymentStatusEnquiry(String transactionId) {
		return PaymentResult.builder().transactionId(transactionId).status(TransactionStatus.SUCCESS).build();
	}
	// Domestic payments
	public PaymentResult domesticPayment(PaymentInitiationRequest p) {
		 return pr(p);
	}
	// Transfer between
	public PaymentResult transferBetweenAccounts(PaymentInitiationRequest p) {
		return pr(p);
	}
	// International
	public PaymentResult internationalPayment(PaymentInitiationRequest p) {
		 return pr(p);
	}
	
	private PaymentResult pr(PaymentInitiationRequest p){
		return PaymentResult.builder().referenceId(p.getGrpHdr().getReferenceId())
				.transactionId("00061")
				.status(TransactionStatus.PROCESSING)
				.paymentInfo(PaymentInfo.builder().instructedAmount(p.getInstructedAmount().getAmount()).instructedCurrency(p.getInstructedAmount().getCurrency()).build())
				.build();
	}
	
}
