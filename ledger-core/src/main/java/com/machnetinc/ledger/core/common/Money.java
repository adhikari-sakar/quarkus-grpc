package com.machnetinc.ledger.core.common;

import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;


@Value
@Getter
public class Money {

    String currency;
    BigDecimal amount;

    public static Money of(String currency, BigDecimal amount) {
        return new Money(currency, amount);
    }
}
