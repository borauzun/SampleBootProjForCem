package com.tbuk.psd2.model.enums;

public enum AccountSubType {
  CURRENT_ACCOUNT("CURRENTACCOUNT"),
  SAVING_ACCOUNT("SAVINGACCOUNT");
  
  String accountSubType;
  AccountSubType(String accountSubType){
	this.accountSubType=accountSubType;
	}
  public String getAccountType() {
	  return this.accountSubType;
  }
}
