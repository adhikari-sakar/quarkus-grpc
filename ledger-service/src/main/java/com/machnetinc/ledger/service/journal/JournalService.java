package com.machnetinc.ledger.service.journal;

import com.machnetinc.ledger.core.common.UniqueId;
import com.machnetinc.ledger.core.journal.Journal;
import com.machnetinc.ledger.core.journal.JournalUseCase;
import com.machnetinc.ledger.porto.JournalGrpcService;
import com.machnetinc.ledger.porto.JournalId;
import com.machnetinc.ledger.porto.JournalResponse;
import com.machnetinc.ledger.porto.TransactionRequest;
import com.machnetinc.ledger.service.interceptor.LogInterceptor;
import com.machnetinc.ledger.service.mapper.JournalMapper;
import com.machnetinc.ledger.service.mapper.TransactionMapper;
import com.machnetinc.ledger.service.transaction.TransactionRepository;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.RegisterInterceptor;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

import static io.smallrye.mutiny.infrastructure.Infrastructure.getDefaultWorkerPool;

@GrpcService
@RegisterInterceptor(LogInterceptor.class)
public class JournalService implements JournalGrpcService {

    @Inject
    TransactionMapper transactionMapper;
    @Inject
    TransactionRepository transactionRepository;
    @Inject
    JournalUseCase journalUseCase;
    @Inject
    JournalMapper journalMapper;
    @Inject
    JournalRepository journalRepository;

    @Override
    @Blocking
    @Transactional
    public Uni<JournalResponse> createJournal(TransactionRequest request) {
        transactionRepository.persist(transactionMapper.toEntity(request));
        var response = journalMapper.toResponse(applyUseCase(request));
        return buildResponse(response);
    }

    private Journal applyUseCase(TransactionRequest request) {
        return journalUseCase.apply(transactionMapper.toModel(request));
    }

    @Override
    @Blocking
    public Uni<JournalResponse> getJournal(JournalId journalId) {
        return journalRepository
                .findById(UniqueId.of(UUID.fromString(journalId.getId())))
                .map(journalMapper::toResponse)
                .map(this::buildResponse)
                .orElseThrow();
    }

    private Uni<JournalResponse> buildResponse(JournalResponse response) {
        return Uni.createFrom().item(response).runSubscriptionOn(getDefaultWorkerPool());
    }

}
