package com.tbuk.psd2.model.response.ais;

import com.tbuk.psd2.model.common.BankAccount;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetail {

	public BankAccount bankAccount;
	public double balance;
}
