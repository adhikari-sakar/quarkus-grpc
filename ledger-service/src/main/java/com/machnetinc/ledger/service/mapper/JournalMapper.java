package com.machnetinc.ledger.service.mapper;

import com.machnetinc.ledger.core.journal.Journal;
import com.machnetinc.ledger.porto.JournalResponse;
import com.machnetinc.ledger.service.common.DateUtils;
import com.machnetinc.ledger.service.journal.JournalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.CollectionMappingStrategy.ADDER_PREFERRED;

@Mapper(componentModel = "cdi", collectionMappingStrategy = ADDER_PREFERRED, uses = DateUtils.class)
public interface JournalMapper {

    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "transferId", source = "transferId.value")
    @Mapping(target = "referenceId", source = "referenceId.value")
    @Mapping(target = "transferredCurrency", source = "transferredMoney.currency")
    @Mapping(target = "transferredAmount", source = "transferredMoney.amount")
    @Mapping(target = "reportingCurrency", source = "reportingMoney.currency")
    @Mapping(target = "reportingAmount", source = "reportingMoney.amount")
    @Mapping(target = "forexRate", source = "forexRate.amount")
    @Mapping(target = "accountId", source = "accountId.id.value")
    JournalResponse toResponse(Journal journal);

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "transferId", target = "transferId.value")
    @Mapping(source = "referenceId", target = "referenceId.value")
    @Mapping(source = "accountId", target = "accountId.id.value")
    Journal toModel(JournalEntity entity);

    @Mapping(target = "transferId", source = "transferId.value")
    @Mapping(target = "referenceId", source = "referenceId.value")
    @Mapping(target = "accountId", source = "accountId.id.value")
    JournalEntity toEntity(Journal model);


}
