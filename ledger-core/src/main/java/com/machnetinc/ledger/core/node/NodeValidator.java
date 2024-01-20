package com.machnetinc.ledger.core.node;

import com.machnetinc.ledger.core.contracts.Validator;
import com.machnetinc.ledger.core.validation.ValidationResult;

public class NodeValidator implements Validator<Node> {

    @Override
    public ValidationResult validate(Node node) {
        return ValidationResult.valid();
    }
}
