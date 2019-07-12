package com.tbuk.psd2.model.response.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.Error;
import com.tbuk.psd2.model.enums.TransactionStatus;
import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.payment.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResult {

	String transactionId;
	String referenceId;
	PaymentInfo paymentInfo;
	TransactionStatus status;
	Error error;
}
