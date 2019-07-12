package com.tbuk.psd2.util;

import com.tbuk.psd2.model.common.Address;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.DateTime;
import com.tbuk.psd2.model.common.GrpHdr;
import com.tbuk.psd2.model.enums.Currency;
import com.tbuk.psd2.model.payment.InstructedAmount;
import com.tbuk.psd2.model.payment.RemittanceInfo;
import com.tbuk.psd2.model.request.PaymentInitiationRequest;

import java.time.LocalDateTime;

public class DummyRequests {

	//  Payment Request samples of Between TBUK Accounts Transfer  //

	public static BankAccount debtor1() {   // debitAcctForBetweenTbukAccount
		return	BankAccount.builder()
				.accountId("08351341")
				.build();
	}

	public static BankAccount creditor1() {   // creditAcctForBetweenTbukAccount
		return	BankAccount.builder()
				.build();
	}

	public static PaymentInitiationRequest betweenAccountsPayment() {

		return PaymentInitiationRequest.builder()
				.debtor(debtor1())
				.creditor(creditor1())
				.remittanceInfo(RemittanceInfo.builder().unstructuredData("School payment, etc.").build())
				.instructedAmount(InstructedAmount.builder().amount(6.35).build())
				.grpHdr(GrpHdr.builder().CreDtTm(new DateTime().getDateTime(LocalDateTime.now())).referenceId("tppRefId001").build())
				.build();
	}


	//  Payment Request samples for Domestıc Transfer  //

	public static BankAccount debtor2() {   // debitAcctForDomestıcTransfer
		return	BankAccount.builder()
				.accountId("08351341")		// Requıred = true
				.currency(Currency.GBP)		// Requıred = true  ,  Valid Currencies are GBP, USD, TRY and EUR
				.build();
	}

	public static BankAccount credtor2_1() {   // creditIbanForDomestıcTransfer
		return	BankAccount.builder()
				.accountId("08351342")
				.sortCode("010101")
				.accountNo("12345678")
				.name("JAMES BOND")			// Requıred = true
				//.address(Address.builder().address("Palmers Green").build())
				.build();
	}

	public static BankAccount credtor2_2() {   // creditAcctForDomestıcTransfer
		return	BankAccount.builder()
				.accountId("2548240512")   			// Requıred = true
				.sortCode("540125")					// Requıred = true
				.name("BENEFICIARY NAME")			// Requıred = true
				.address(Address.builder().address("Palmers Green").build())
				.build();
	}

	public static PaymentInitiationRequest domesticPayment1_1() {    // IF domestıc Transfer to IBAN sample

		return PaymentInitiationRequest.builder()
				.debtor(debtor2())        // Requıred = true
				.creditor(credtor2_1())     // Requıred = true
				.instructedAmount(InstructedAmount.builder().amount(200.00).build())   // Requıred = true
				.remittanceInfo(RemittanceInfo.builder().unstructuredData("Domestic Transfer To IBAN Test").build())  // Requıred = true
				.build();
	}

	public static PaymentInitiationRequest domesticPayment1_2() {    // IF domestıc Transfer to Acct sample

		return PaymentInitiationRequest.builder()
				.debtor(debtor2())        // Requıred = true
				.creditor(credtor2_2())     // Requıred = true
				.instructedAmount(InstructedAmount.builder().amount(500.50).build())   // Requıred = true
				.remittanceInfo(RemittanceInfo.builder().unstructuredData("Domestic Transfer To Acct Test").build())  // Requıred = true
				.build();
	}


	//  Payment Request samples for International Transfer  //


	public static BankAccount debtor3() {   // debitAcctForDomestıcTransfer
		return	BankAccount.builder()
				.accountId("08351341")		// Requıred = true
				.currency(Currency.USD)		// Requıred = true  ,  Valid Currencies are GBP, USD, TRY and EUR
				.build();
	}

	public static BankAccount creditor3_1() {   // creditIbanForInternatıonalTransfer
		return	BankAccount.builder()
				.iban("TR570001001376804240195002")   	// Requıred = true
				.name("BORA UZUN")					// Requıred = true
				.bicCode("TCZBTR2A")					// Requıred = true
				.currency(Currency.GBP)					// Requıred = true
				.address(Address.builder().address("Kastel mevki").city("Trabzon").country("TR").postCode("61000").build())
				.build();
	}

	public static BankAccount creditor3_2() {   // creditAcctForInternatıonalTransfer
		return	BankAccount.builder()
				.accountId("7280531")   				// Requıred = true
				.name("CEM TEZER")					// Requıred = true
				.bicCode("TUBATRISTBL")					// Requıred = true
				.currency(Currency.EUR)					// Requıred = true
				.address(Address.builder().address("Kastel mevki").city("Trabzon").country("TR").postCode("61000").build())
				.build();
	}

	public static BankAccount creditor3_3() {   // creditNormForInternatıonalTransfer  (Sadece Isme de swift yapilabilirmis)
		return	BankAccount.builder()
				.name("MEHMET AKKILINC")						// Requıred = true
				.bicCode("TUBATRISTBL")							// Requıred = true
				.currency(Currency.GBP)							// Requıred = true
				.address(Address.builder().address("Kastel mevki").city("Trabzon").country("TR").postCode("61000").build())
				.build();
	}



	public static PaymentInitiationRequest internationalPayment1_1() {   // IF Transfer to IBAN sample

		return PaymentInitiationRequest.builder()
				.debtor(debtor3())
				.creditor(creditor3_1())
				.instructedAmount(InstructedAmount.builder().amount(2000.00).build())   // Requıred = true
				.remittanceInfo(RemittanceInfo.builder().unstructuredData("International Transfer To IBAN Test").build())  // Requıred = true
				.build();
	}


	public static PaymentInitiationRequest internationalPayment1_2() {   // IF Transfer to Acct sample

		return PaymentInitiationRequest.builder()
				.debtor(debtor3())
				.creditor(creditor3_2())
				.instructedAmount(InstructedAmount.builder().amount(1000.00).build())   // Requıred = true
				.remittanceInfo(RemittanceInfo.builder().unstructuredData("International Transfer To Acct Test").build())  // Requıred = true
				.build();
	}


	public static PaymentInitiationRequest internationalPayment1_3() {   // IF Transfer to IBAN sample

		return PaymentInitiationRequest.builder()
				.debtor(debtor3())
				.creditor(creditor3_3())
				.instructedAmount(InstructedAmount.builder().amount(5500.50).build())   // Requıred = true
				.remittanceInfo(RemittanceInfo.builder().unstructuredData("International Transfer To Norm Test").build())  // Requıred = true
				.build();
	}



}
