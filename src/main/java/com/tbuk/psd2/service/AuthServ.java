package com.tbuk.psd2.service;

import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.enums.AccountSubType;
import com.tbuk.psd2.model.enums.Currency;
import com.tbuk.psd2.model.response.auth.BankAuthorization;
import com.tbuk.psd2.model.response.auth.PaymentUID;
import com.tbuk.psd2.util.DummyRequests;
import com.tbuk.psd2.util.Samples1;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthServ {

    public PaymentUID getPaymentUID(){
        String uid=UUID.randomUUID().toString();
        return new PaymentUID(uid);
    }

    public BankAuthorization getAuthorisation(){
        List<BankAccount> list=new ArrayList<BankAccount>();
        list.add(bankAcc1());
        list.add(bankAcc2());
        return BankAuthorization.builder().bankAccounts(list).psuMember_id("61").build();
    }

    private BankAccount bankAcc1(){
        BankAccount b=new BankAccount();
        b.setAccountId("001");
        b.setAccountNo("08371199");
        b.setAccountSubType(AccountSubType.CURRENT_ACCOUNT);
        b.setBicCode("TBUKGB2L");
        b.setCurrency(Currency.GBP);
        b.setName("OMER AYAN");
        b.setIban("GB93TUBA40519808371199");
        b.setStatementAvailable(true);
        b.setSortCode("405033");
        return b;
    }
    private BankAccount bankAcc2(){
        BankAccount b=new BankAccount();
        b.setAccountId("0002");
        b.setAccountNo("08351341");
        b.setAccountSubType(AccountSubType.CURRENT_ACCOUNT);
        b.setBicCode("TBUKGB2L");
        b.setCurrency(Currency.EUR);
        b.setName("OMER AYAN");
        b.setIban("GB43TUBA40519808351341");
        b.setStatementAvailable(false);
        b.setSortCode("405033");
        return b;
    }
}
