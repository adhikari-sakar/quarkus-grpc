package com.machnetinc.ledger.service.transaction;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionRepository implements PanacheRepository<TransactionEntity> {

    public void save(TransactionEntity transaction) {
        persist(transaction);
    }

    public Optional<TransactionEntity> findById(UUID id) {
        return find("id", id).firstResultOptional();
    }

    public List<TransactionEntity> getAll() {
        return findAll().stream().collect(toList());
    }
}
