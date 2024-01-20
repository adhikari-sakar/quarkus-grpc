package com.machnetinc.ledger.client;

import com.machnetinc.ledger.client.journal.TransactionTestData;
import com.machnetinc.ledger.porto.JournalGrpcServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@QuarkusTest
@Testcontainers
public class GrpcClientIntegrationTest {

    @Container
    public static final GenericContainer<?> grpcServerContainer = new GenericContainer<>("your/grpc-server-image")
            .withExposedPorts(9090);

    private static final ManagedChannel channel = ManagedChannelBuilder
            .forAddress(grpcServerContainer.getHost(), grpcServerContainer.getMappedPort(9090))
            .usePlaintext()
            .build();

//    @Test
    public void testJournalGrpcStub() {
        // Obtain the gRPC server address from the container
        String grpcServerAddress = grpcServerContainer.getHost() + ":" + grpcServerContainer.getMappedPort(9090);
        System.out.println(grpcServerAddress);

        // Initialize your gRPC blocking stub with the server address
        var blockingStub = JournalGrpcServiceGrpc.newBlockingStub(channel);

        // Perform test using the blocking stub
        var response = blockingStub.createJournal(TransactionTestData.transactionRequest().build());
        System.out.println(response);
        Assertions.assertThat(response).isNotNull();
    }
}