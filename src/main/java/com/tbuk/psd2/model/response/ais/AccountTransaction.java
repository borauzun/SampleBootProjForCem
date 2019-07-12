package com.tbuk.psd2.model.response.ais;

import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.enums.Currency;
import com.tbuk.psd2.model.enums.TransactionStatus;
import com.tbuk.psd2.model.payment.Charge;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class AccountTransaction {
    private  String transactionId;
    private  String referenceId;
    private  BankAccount from;
    private  BankAccount to;
    private  double amount;
    private  Currency currency;
    private  String description;
    private  TransactionStatus status;
    private  Charge chargeInfo;
    //private final StatusCode status;
}
