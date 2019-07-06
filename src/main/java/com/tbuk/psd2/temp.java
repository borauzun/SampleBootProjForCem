package com.tbuk.psd2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.enums.AccountType;
import com.tbuk.psd2.model.enums.Currency;
import com.tbuk.psd2.model.payment.Charge;

public class temp {

	public static void main(String[] args) throws JsonProcessingException {
		BankAccount b=BankAccount.builder().accountNo("1")
				                           .accountType(AccountType.PERSONAL)
				                           .bicCode("bic")
				                           .currency(Currency.GBP)
				                           .iban("iban")
				                           .sortCode("010101")
				                           .build();
		
		Charge c=new Charge();
		c.setAmount(10);
		c.setText("");
		
		Charge c2=new Charge(10,"");
		
		Charge c3=Charge.builder().amount(10).build();
		
		 ObjectMapper mapper = new ObjectMapper();
		 String dtoAsString = mapper.writeValueAsString(b);
	
	  System.out.println(dtoAsString);
	}

}
