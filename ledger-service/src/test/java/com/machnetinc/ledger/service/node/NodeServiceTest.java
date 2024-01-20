package com.machnetinc.ledger.service.node;

import com.machnetinc.ledger.porto.NodeGrpcService;
import com.machnetinc.ledger.porto.NodeId;
import com.machnetinc.ledger.porto.NodeResponse;
import com.machnetinc.ledger.service.NonTransactionalQuarkusTest;
import io.quarkus.grpc.GrpcClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@NonTransactionalQuarkusTest
class NodeServiceTest {

    @GrpcClient
    NodeGrpcService client;

    private static final List<String> uuidList = new ArrayList<>();

    @BeforeEach
    void shouldAddNew() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<NodeResponse> message = new CompletableFuture<>();
        client.createNode(NodeTestData.nodeRequest().build())
                .subscribe().with(message::complete);
        NodeResponse response = message.get(1, TimeUnit.SECONDS);
        assertNode(response);
        uuidList.add(response.getId());
    }

    @Test
    void shouldFindById() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<NodeResponse> message = new CompletableFuture<>();
        client.getNode(NodeId.newBuilder().setId(uuidList.get(0)).build())
                .subscribe().with(message::complete);
        NodeResponse response = message.get(1, TimeUnit.SECONDS);
        assertNode(response);
    }

    private static void assertNode(NodeResponse response) {
        assertNotNull(response);
        assertEquals("Test Node", response.getName());
        assertEquals("Test Affiliate", response.getAffiliate());
        assertEquals("AFFILIATE", response.getType());
    }
}