package com.machnetinc.ledger.core.validation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationResult {

    List<Violation> violations;

    public boolean isValid() {
        return violations.isEmpty();
    }

    public static ValidationResult valid() {
        return new ValidationResult(new ArrayList<>());
    }

    public static ValidationResult invalid(List<Violation> violations) {
        return new ValidationResult(violations);
    }

    public ValidationResult andThen(Supplier<ValidationResult> resultSupplier) {
        return isValid() ? resultSupplier.get() : this;
    }
}
