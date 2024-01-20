package com.machnetinc.ledger.service.node;

import com.machnetinc.ledger.core.common.UniqueId;
import com.machnetinc.ledger.core.contracts.BaseRepository;
import com.machnetinc.ledger.core.node.Node;
import com.machnetinc.ledger.service.mapper.NodeMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class NodeRepository implements BaseRepository<Node>, PanacheRepository<NodeEntity> {

    @Inject
    NodeMapper mapper;

    @Override
    @Transactional
    public Node save(Node node) {
        var entity = mapper.toEntity(node);
        persist(entity);
        return mapper.toModel(entity);
    }

    @Override
    public Optional<Node> findById(UniqueId<?> uniqueId) {
        return find("id", uniqueId.getValue()).firstResultOptional().map(mapper::toModel);
    }

    @Override
    public List<Node> getAll() {
        return findAll().stream().map(mapper::toModel).collect(toList());
    }
}
