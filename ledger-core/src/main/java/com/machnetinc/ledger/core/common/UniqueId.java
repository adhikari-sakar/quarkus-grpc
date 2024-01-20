package com.machnetinc.ledger.core.common;

import lombok.Getter;
import lombok.Value;


@Value
@Getter
public class UniqueId<T extends Comparable<T>> {

    T value;

    public static <R extends Comparable<R>> UniqueId<R> of(R id) {
        return new UniqueId<>(id);
    }
}
