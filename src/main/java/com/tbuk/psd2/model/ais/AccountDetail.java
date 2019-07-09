package com.tbuk.psd2.model.ais;

import com.tbuk.psd2.model.common.BankAccount;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountDetail {

	private BankAccount bankAccount;
	private double balance;
}
