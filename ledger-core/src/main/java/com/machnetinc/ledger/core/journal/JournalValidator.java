package com.machnetinc.ledger.core.journal;

import com.machnetinc.ledger.core.contracts.Validator;
import com.machnetinc.ledger.core.validation.ValidationResult;

public class JournalValidator implements Validator<Journal> {

    @Override
    public ValidationResult validate(Journal model) {
        return ValidationResult.valid();
    }
}
