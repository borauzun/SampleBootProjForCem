package com.tbuk.psd2.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.tbuk.psd2.model.enums.AccountSubType;
import com.tbuk.psd2.model.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonRootName("BankAccount")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "name", "id" })
//@JsonPropertyOrder(alphabetic=true)
public class BankAccount {
	
	private String accountId;
	private String name;
	private String sortCode;
	private String accountNo;
	private String bicCode;
	private Address address;
	private String iban;
	private Currency currency;
	private AccountSubType accountSubType;
	private boolean statementAvailable;
	
	
}
