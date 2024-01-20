package com.machnetinc.ledger.core.common;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class User {

    String name;
    UniqueId<String> id;
}
