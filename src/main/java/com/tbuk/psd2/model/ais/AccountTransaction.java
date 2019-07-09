package com.tbuk.psd2.model.ais;

import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.enums.Currency;
import com.tbuk.psd2.model.enums.TransactionType;

public final class AccountTransaction {
    private  TransactionType type;
	private  String transactionId;
    private  String referenceId;
    private  BankAccount from;
    private  BankAccount to;
    private  double amount;
    private  Currency currency;
    private  double transferAmount;
    private  Currency transferCurrency;
    private  String description;
    private  String status;
    //private final StatusCode status;
}
