package com.tbuk.psd2.model.response.auth;

import java.util.List;

import com.tbuk.psd2.model.common.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BankAuthorization {
	
	private List<BankAccount> bankAccounts;
	private String psuMember_id;
    
}
