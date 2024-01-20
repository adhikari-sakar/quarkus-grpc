package com.machnetinc.ledger.client.journal;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionEventData {

    public static TransactionEvent transactionEvent() {
        final TransactionEvent msg = new TransactionEvent();
        msg.setUserId(UUID.randomUUID().toString());
        msg.setAssociatedUser(UUID.randomUUID().toString());
        msg.setUserFundingAccount(UUID.randomUUID().toString());
        msg.setAssociatedUserAccount(UUID.randomUUID().toString());
        msg.setRecipientCurrency("USD");
        msg.setSenderCurrency("USD");
        msg.setExchangeRate(new BigDecimal("132.55"));
        msg.setSenderAmount(BigDecimal.valueOf(100));
        msg.setTotalSenderAmount(BigDecimal.valueOf(1000));
        msg.setFeeAmount(BigDecimal.TEN);
        msg.setBonusAmount(BigDecimal.ONE);
        return msg;
    }
}
