package com.machnetinc.ledger.core.contracts;

public interface UseCase<T, R> {

    R apply(T model);
}
