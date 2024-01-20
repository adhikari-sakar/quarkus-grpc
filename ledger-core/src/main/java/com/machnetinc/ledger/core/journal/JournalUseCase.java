package com.machnetinc.ledger.core.journal;

import com.machnetinc.ledger.core.common.BaseModel;
import com.machnetinc.ledger.core.common.UniqueId;
import com.machnetinc.ledger.core.contracts.BaseRepository;
import com.machnetinc.ledger.core.contracts.UseCase;
import com.machnetinc.ledger.core.transaction.Transaction;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class JournalUseCase implements UseCase<Transaction, Journal> {

    private final JournalValidator validator;
    private final BaseRepository<Journal> repository;

    @Override
    public Journal apply(Transaction transaction) {
        // validate & create journal(s) from transaction and return Journal Model
        return JournalFactory.createJournal(transaction)
                .andThen(this::validate)
                .andThenIf(Journal::isValid, repository::save);
    }

    private Journal validate(BaseModel<UniqueId<UUID>> journal) {
        return journal.validate(List.of(validator));
    }
}
