package com.machnetinc.ledger.service.journal;

import com.machnetinc.ledger.core.journal.Journal;
import com.machnetinc.ledger.core.journal.Journal.JournalStatus;
import com.machnetinc.ledger.service.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "JOURNAL")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntity extends BaseEntity {

    private String transferId;

    private String referenceId;

    @Enumerated(EnumType.STRING)
    private Journal.JournalType type;

    @Embedded
    @AttributeOverride(name = "currency", column = @Column(name = "transferred_currency"))
    @AttributeOverride(name = "amount", column = @Column(name = "transferred_amount"))
    private MoneyEmbeddable transferredMoney;

    @Embedded
    @AttributeOverride(name = "currency", column = @Column(name = "reporting_currency"))
    @AttributeOverride(name = "amount", column = @Column(name = "reporting_amount"))
    private MoneyEmbeddable reportingMoney;

    @Embedded
    @AttributeOverride(name = "currency", column = @Column(name = "forex_currency"))
    @AttributeOverride(name = "amount", column = @Column(name = "forex_rate"))
    private MoneyEmbeddable forexRate;

    private String accountId;

    private LocalDateTime confirmedAt;

    @Enumerated(EnumType.STRING)
    private JournalStatus status;

    @Data
    @Embeddable
    public static class MoneyEmbeddable implements Serializable {

        private String currency;
        private BigDecimal amount;
    }

}
