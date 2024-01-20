package com.machnetinc.ledger.core.validation;

import lombok.Getter;
import lombok.Value;

@Value(staticConstructor = "of")
@Getter
public class Violation {

    String key;
    String message;
}
