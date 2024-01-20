package com.machnetinc.ledger.core.common;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class Account {

    String name;
    AccountId accountId;
}
