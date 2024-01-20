package com.machnetinc.ledger.service.transaction;

import com.machnetinc.ledger.core.transaction.Transaction;
import com.machnetinc.ledger.porto.TransactionRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TransactionMapper {

    Transaction toModel(TransactionRequest request);

    TransactionEntity toEntity(Transaction model);

    Transaction toModel(TransactionEntity entity);
}
