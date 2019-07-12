package com.tbuk.psd2.model.payment;

import com.tbuk.psd2.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charge {
    String chargeName;
    double amount;
    Currency currency;
    double tax;
}
