package com.machnetinc.ledger.core.common;

import com.machnetinc.ledger.core.contracts.BaseRepository;
import com.machnetinc.ledger.core.contracts.Validator;
import com.machnetinc.ledger.core.validation.Violation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
@Setter
public abstract class BaseModel<ID extends UniqueId<?>> {

    private ID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Violation> violations = new ArrayList<>();

    public <T extends BaseModel<ID>> T validate(List<Validator<T>> validators) {
        for (Validator<T> validator : validators) {
            var result = validator.validate(thisObject());
            if (!result.isValid()) addViolations(result.getViolations());
        }
        return thisObject();
    }

    private void addViolations(List<Violation> violations) {
        this.violations.addAll(violations);
    }

    public <T extends BaseModel<ID>> T save(BaseRepository<T> repository) {
        return repository.save(thisObject());
    }

    public <T extends BaseModel<ID>> T andThen(Function<T, T> modelFunction) {
        return modelFunction.apply(thisObject());
    }

    public <T extends BaseModel<ID>> T andThenIf(Predicate<T> preCondition, Function<T, T> modelFunction) {
        return preCondition.test(thisObject()) ? modelFunction.apply(thisObject()) : thisObject();
    }

    public <T extends BaseModel<ID>> T andThrowIf(Predicate<T> preCondition) {
        if (preCondition.test(thisObject()))
            throw new RuntimeException("Failed to create journal");
        return thisObject();
    }

    private <T extends BaseModel<ID>> T thisObject() {
        return (T) this;
    }

    public boolean isValid() {
        return this.violations.isEmpty();
    }

    public boolean isInvalid() {
        return !isValid();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseModel)) return false;
        if (getClass() != o.getClass()) return false;
        BaseModel<?> model = (BaseModel<?>) o;
        return Objects.equals(id.getValue(), model.id.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id.getValue());
    }

    @Override
    public String toString() {
        return id.getValue().toString();
    }
}
