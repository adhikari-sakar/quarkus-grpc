package com.machnetinc.ledger.client.journal;

import com.machnetinc.ledger.porto.TransactionRequest;

import java.util.UUID;

public class TransactionTestData {

    public static TransactionRequest.Builder transactionRequest() {
        return TransactionRequest.newBuilder()
                .setTransactionId(UUID.randomUUID().toString())
                .setUserId(UUID.randomUUID().toString())
                .setAssociatedUser(UUID.randomUUID().toString())
                .setAssociatedUserAccount(UUID.randomUUID().toString())
                .setSenderCurrency("USD")
                .setRecipientCurrency("USD")
                .setExchangeRate(132.5d)
                .setSenderAmount(1000d)
                .setTotalSenderAmount(10000d)
                .setFeeAmount(5d)
                .setBonusAmount(10d);
    }
}
