package com.machnetinc.ledger.core.contracts;

import com.machnetinc.ledger.core.common.BaseModel;
import com.machnetinc.ledger.core.common.UniqueId;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseModel<?>> {

    T save(T model);

    Optional<T> findById(UniqueId<?> uniqueId);

    List<T> getAll();
}
