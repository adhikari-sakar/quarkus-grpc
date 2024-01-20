package com.machnetinc.ledger.service.journal;


import com.machnetinc.ledger.core.common.UniqueId;
import com.machnetinc.ledger.core.contracts.BaseRepository;
import com.machnetinc.ledger.core.journal.Journal;
import com.machnetinc.ledger.service.mapper.JournalMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class JournalRepository implements BaseRepository<Journal>, PanacheRepository<JournalEntity> {

    @Inject
    JournalMapper mapper;

    @Override
    @Transactional
    public Journal save(Journal journal) {
        var entity = mapper.toEntity(journal);
        persist(entity);
        return mapper.toModel(entity);
    }

    @Override
    public Optional<Journal> findById(UniqueId<?> uniqueId) {
        return find("id", uniqueId.getValue()).firstResultOptional().map(mapper::toModel);
    }

    @Override
    public List<Journal> getAll() {
        return findAll().stream().map(mapper::toModel).collect(toList());
    }
}
