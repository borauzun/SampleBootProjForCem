package com.tbuk.psd2.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tbuk.psd2.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentInfo {

	double instructedAmount;
	Currency instructedCurrency;
	double rate;
	double convertedAmount;
	Charge charge;

}
