package com.machnetinc.ledger.client.node;

public class NodeEventData {

    public static NodeEvent nodeEvent() {
        return NodeEvent.builder()
                .accountId("AC001")
                .affiliate("Test Affiliate")
                .name("Test Node")
                .type("USER")
                .build();
    }
}
