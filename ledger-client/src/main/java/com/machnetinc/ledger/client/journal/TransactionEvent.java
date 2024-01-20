package com.machnetinc.ledger.client.journal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {

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
