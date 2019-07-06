package com.tbuk.psd2.model.payment;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.GrpHdr;
import com.tbuk.psd2.model.enums.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author borauzun
 * grpHdr   		: General reference information such as referenceId, DateTime of message initiation, Payment Type, etc
 * debtor   		: From account
 * creditor 		: To account
 * instructedAmount : Money amount and target Currency. 
 * remittanceInfo   : Remittance info such as description, reference text, etc. (unstructured data)  
 * Sample 1 : Domestic Instant Payment, UK GBP Account To UK GBP Account
 * Sample 2 : Domestic Instant Payment, UK EURO Account to UK GBP Account
 * Sample 3 : Domestic FDP(One off)   , UK GBP Account to UK GBP Account
 * Sample 4 : Domestic Standing Order , UK GBP Account to UK GBP Account repeats monthly
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonRootName("PaymentInitiationRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomesticPaymentInitiationRequest {
	private GrpHdr grpHdr;
	private BankAccount debtor;
	private BankAccount creditor;
	private InstructedAmount instructedAmount;
	private RemittanceInfo remittanceInfo;
	
	
	public boolean validate() {
		// fill here for the validation - burada gelen mesaji validate et, bilgiler girilmis mi
		 
		return true;	
		}
}
