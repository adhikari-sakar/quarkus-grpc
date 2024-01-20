package com.machnetinc.ledger.core.journal;

import com.machnetinc.ledger.core.common.AccountId;
import com.machnetinc.ledger.core.common.Money;
import com.machnetinc.ledger.core.common.UniqueId;
import com.machnetinc.ledger.core.transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.machnetinc.ledger.core.journal.Journal.JournalStatus.CREATED;
import static com.machnetinc.ledger.core.journal.Journal.JournalType.DEBIT;

class JournalFactory {

    // create journal(s) based on transaction
    public static Journal createJournal(Transaction transaction) {
        return new Journal(
                UniqueId.of(transaction.getTransactionId()),
                UniqueId.of(transaction.getTransactionId()),
                DEBIT,
                Money.of(transaction.getSenderCurrency(), transaction.getSenderAmount()),
                Money.of(transaction.getSenderCurrency(), transaction.getSenderAmount()),
                Money.of("USD", BigDecimal.ONE),
                AccountId.of(UniqueId.of(UUID.fromString(transaction.getAssociatedUserAccount()))),
                CREATED,
                LocalDateTime.now()
        );
    }
}
