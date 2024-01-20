package com.machnetinc.ledger.core.contracts;

import com.machnetinc.ledger.core.common.BaseModel;
import com.machnetinc.ledger.core.validation.ValidationResult;

public interface Validator<T extends BaseModel<?>> {

    ValidationResult validate(T model);
}
