package com.machnetinc.ledger.client;

import com.machnetinc.ledger.porto.JournalGrpcServiceGrpc;
import com.machnetinc.ledger.porto.NodeGrpcServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GrpcClient {

    @Inject
    @ConfigProperty(name = "server.url")
    String serverUrl;

    @Inject
    @ConfigProperty(name = "server.port")
    int serverPort;

    private final ManagedChannel channel = buildManagedChannel();

    private ManagedChannel buildManagedChannel() {
        return ManagedChannelBuilder
                .forAddress(serverUrl, serverPort)
                .usePlaintext()
                .build();
    }


    public JournalGrpcServiceGrpc.JournalGrpcServiceBlockingStub getJournalStub() {
        return JournalGrpcServiceGrpc.newBlockingStub(channel);
    }

    public NodeGrpcServiceGrpc.NodeGrpcServiceBlockingStub getNodeStub() {
        return NodeGrpcServiceGrpc.newBlockingStub(channel);
    }


    @PreDestroy
    public void preDestroy() {
        if (channel != null) {
            channel.shutdown();
        }
    }
}
