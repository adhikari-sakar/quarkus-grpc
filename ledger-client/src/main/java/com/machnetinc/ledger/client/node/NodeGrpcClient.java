package com.machnetinc.ledger.client.node;

import com.machnetinc.ledger.client.GrpcClient;
import com.machnetinc.ledger.porto.NodeId;
import com.machnetinc.ledger.porto.NodeRequest;
import com.machnetinc.ledger.porto.NodeResponse;
import com.machnetinc.ledger.porto.NodeType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NodeGrpcClient {

    @Inject
    GrpcClient grpcClient;

    public NodeResponse createNode(NodeEvent msg) {
        final NodeRequest request = buildRequest(msg);
        return grpcClient.getNodeStub().createNode(request);
    }

    public NodeResponse getNode(String nodeId) {
        return grpcClient.getNodeStub().getNode(NodeId.newBuilder().setId(nodeId).build());
    }

    private static NodeRequest buildRequest(NodeEvent msg) {
        return NodeRequest.newBuilder()
                .setName(msg.getName())
                .setAccountId(msg.getAccountId())
                .setAffiliate(msg.getAffiliate())
                .setType(NodeType.valueOf(msg.getType()))
                .build();
    }

}
