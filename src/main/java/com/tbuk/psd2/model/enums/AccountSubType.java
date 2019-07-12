package com.tbuk.psd2.model.enums;

public enum AccountSubType {
    CURRENT_ACCOUNT("CURRENTACCOUNT"),
    NOTICE_ACCOUNT("NOTICEACCOUNT"),
    TIME_DEPOSITS("TIMEDEPOSIT");
  
  String accountSubType;
  AccountSubType(String accountSubType){
	this.accountSubType=accountSubType;
	}
  public String getAccountType() {
	  return this.accountSubType;
  }
}
