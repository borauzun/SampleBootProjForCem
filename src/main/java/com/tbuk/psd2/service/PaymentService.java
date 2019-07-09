package com.tbuk.psd2.service;

import org.springframework.stereotype.Service;

import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.response.PaymentResult;

@Service
public class PaymentService {
	
	// Generic
	public Charge chargeEnquiry() {
		return null;
	}
	public double rateEnquiry() {
		return 1.1;
	}
	public PaymentResult paymentStatusEnquiry() {
		return null;
	}
	// Domestic payments
	public PaymentResult domesticPayment() {
		return null;
	}
	// Transfer between
	public PaymentResult transferBetweenAccounts() {
		return null;
	}
	// International
	public PaymentResult internationalPayment() {
		return null;
	}
	
	
	
}
