package com.machnetinc.ledger.core.journal;

import com.machnetinc.ledger.core.common.AccountId;
import com.machnetinc.ledger.core.common.Money;
import com.machnetinc.ledger.core.common.UniqueId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class JournalTestData {

    public static Journal debitJournal() {
        return new Journal(
                UniqueId.of("1"),
                UniqueId.of("2"),
                Journal.JournalType.DEBIT,
                Money.of("USD", BigDecimal.TEN),
                Money.of("USD", BigDecimal.TEN),
                Money.of("USD", BigDecimal.ONE),
                AccountId.of(UniqueId.of(UUID.randomUUID())),
                Journal.JournalStatus.CREATED,
                LocalDateTime.now()
        );
    }
}
