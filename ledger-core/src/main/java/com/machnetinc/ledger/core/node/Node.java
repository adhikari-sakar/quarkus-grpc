package com.machnetinc.ledger.core.node;

import com.machnetinc.ledger.core.common.Account;
import com.machnetinc.ledger.core.common.Affiliate;
import com.machnetinc.ledger.core.common.BaseModel;
import com.machnetinc.ledger.core.common.UniqueId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
@RequiredArgsConstructor
public class Node extends BaseModel<UniqueId<UUID>> {

    String name;
    Account account;
    NodeType type;
    NodeStatus status;
    Affiliate affiliate;

    public enum NodeType {
        PLATFORM,
        AFFILIATE,
        USER,
        PAYOUT
    }

    public enum NodeStatus {
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
