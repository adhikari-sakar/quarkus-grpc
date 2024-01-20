package com.machnetinc.ledger.service.transaction;

import com.machnetinc.ledger.service.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "TRANSACTION")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity extends BaseEntity {

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
