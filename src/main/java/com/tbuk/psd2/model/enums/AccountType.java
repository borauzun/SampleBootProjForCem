package com.tbuk.psd2.model.enums;

public enum AccountType {
  PERSONAL("PERSONAL"),
  BUSINESS("BUSINESS");
  
  String accountType;
  AccountType(String accountType){
	this.accountType=accountType;
	}
  public String getAccountType() {
	  return this.accountType;
  }
}
