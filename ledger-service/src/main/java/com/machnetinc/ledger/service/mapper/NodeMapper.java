package com.machnetinc.ledger.service.mapper;

import com.machnetinc.ledger.core.node.Node;
import com.machnetinc.ledger.porto.NodeRequest;
import com.machnetinc.ledger.porto.NodeResponse;
import com.machnetinc.ledger.service.common.MappingUtils;
import com.machnetinc.ledger.service.node.NodeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

import static org.mapstruct.MappingConstants.ANY_REMAINING;
import static org.mapstruct.MappingConstants.NULL;

@Mapper(componentModel = "cdi", uses = MappingUtils.class)
public interface NodeMapper {

    @Mapping(target = "affiliate", source = "affiliate.name")
    @Mapping(target = "accountId", source = "account.accountId.id.value")
    NodeEntity toEntity(Node node);

    @Mapping(target = "affiliate.name", source = "affiliate")
    @Mapping(target = "account.accountId.id.value", source = "accountId")
    @ValueMapping(source = ANY_REMAINING, target = NULL)
    Node toModel(NodeRequest request);

    @Mapping(target = "affiliate.name", source = "affiliate")
    @Mapping(target = "account.accountId.id.value", source = "accountId")
    Node toModel(NodeEntity entity);

    @Mapping(target = "affiliate", source = "affiliate.name")
    @Mapping(target = "accountId", source = "account.accountId.id.value")
    NodeResponse toResponse(Node node);

}
