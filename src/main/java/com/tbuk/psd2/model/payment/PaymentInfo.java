package com.tbuk.psd2.model.payment;

import com.tbuk.psd2.model.enums.Currency;

public class PaymentInfo {

	double instructedAmount;
	Currency instructedCurrency;
	double rate;
	double convertedAmount;
	Charge charge;

}
