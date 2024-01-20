package com.machnetinc.ledger.service.mapper;

import com.machnetinc.ledger.core.transaction.Transaction;
import com.machnetinc.ledger.porto.TransactionRequest;
import com.machnetinc.ledger.service.transaction.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TransactionMapper {

    Transaction toModel(TransactionRequest request);

    TransactionEntity toEntity(TransactionRequest request);

}
