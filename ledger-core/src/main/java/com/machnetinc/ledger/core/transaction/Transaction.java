package com.machnetinc.ledger.core.transaction;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
    private String transactionId;
    private String userId;
    private String associatedUser;
    private String userFundingAccount;
    private String associatedUserAccount;
    private String senderCurrency;
    private String recipientCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal senderAmount;
    private BigDecimal totalSenderAmount;
    private BigDecimal feeAmount;
    private BigDecimal bonusAmount;
}
