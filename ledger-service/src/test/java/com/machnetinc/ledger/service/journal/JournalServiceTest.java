package com.machnetinc.ledger.service.journal;

import com.machnetinc.ledger.porto.JournalGrpcService;
import com.machnetinc.ledger.porto.JournalId;
import com.machnetinc.ledger.porto.JournalResponse;
import com.machnetinc.ledger.service.NonTransactionalQuarkusTest;
import com.machnetinc.ledger.service.transaction.TransactionTestData;
import io.quarkus.grpc.GrpcClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@NonTransactionalQuarkusTest
class JournalServiceTest {

    @GrpcClient
    JournalGrpcService client;
    private static final List<String> uuidList = new ArrayList<>();

    @BeforeEach
    void shouldAddNew() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<JournalResponse> message = new CompletableFuture<>();
        client.createJournal(TransactionTestData.transactionRequest().build())
                .subscribe().with(message::complete);
        JournalResponse response = message.get(1, TimeUnit.SECONDS);
        assertNotNull(response);
        assertNotNull(response.getReferenceId());
        uuidList.add(response.getId());
    }

    @Test
    void shouldFindById() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<JournalResponse> message = new CompletableFuture<>();
        client.getJournal(JournalId.newBuilder().setId(uuidList.get(0)).build())
                .subscribe().with(message::complete);
        JournalResponse response = message.get(1, TimeUnit.SECONDS);
        assertNotNull(response);
        assertNotNull(response.getReferenceId());
    }
}