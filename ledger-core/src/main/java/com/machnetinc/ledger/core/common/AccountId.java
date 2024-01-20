package com.machnetinc.ledger.core.common;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class AccountId {

    UniqueId<UUID> id;

    public static AccountId of(UniqueId<UUID> uniqueId) {
        return new AccountId(uniqueId);
    }
}
