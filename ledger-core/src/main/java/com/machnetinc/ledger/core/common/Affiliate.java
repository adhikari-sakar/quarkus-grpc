package com.machnetinc.ledger.core.common;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class Affiliate {

    String name;
    AccountId accountId;
}
