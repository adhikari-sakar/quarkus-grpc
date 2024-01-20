package com.machnetinc.ledger.service.node;

import com.machnetinc.ledger.porto.NodeRequest;
import com.machnetinc.ledger.porto.NodeType;

import java.util.UUID;

public class NodeTestData {

    public static NodeRequest.Builder nodeRequest() {
        return NodeRequest.newBuilder()
                .setName("Test Node")
                .setAccountId(UUID.randomUUID().toString())
                .setType(NodeType.AFFILIATE)
                .setAffiliate("Test Affiliate");
    }
}
