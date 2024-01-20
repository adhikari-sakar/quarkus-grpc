package com.machnetinc.ledger.core.journal;

import com.machnetinc.ledger.core.common.AccountId;
import com.machnetinc.ledger.core.common.BaseModel;
import com.machnetinc.ledger.core.common.Money;
import com.machnetinc.ledger.core.common.UniqueId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;


@Value
@Getter
@ToString(callSuper = true)
@RequiredArgsConstructor
public class Journal extends BaseModel<UniqueId<UUID>> {

    UniqueId<String> transferId;
    UniqueId<String> referenceId;
    JournalType type;
    Money transferredMoney;
    Money reportingMoney;
    Money forexRate;
    AccountId accountId;
    JournalStatus status;
    LocalDateTime confirmedAt;

    public enum JournalType {
        DEBIT,
        CREDIT
    }

    public enum JournalStatus {
        CREATED,
        FAILED
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
