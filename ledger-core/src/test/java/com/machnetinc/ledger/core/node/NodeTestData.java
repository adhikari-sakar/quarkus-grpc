package com.machnetinc.ledger.core.node;

import com.machnetinc.ledger.core.common.Account;
import com.machnetinc.ledger.core.common.AccountId;
import com.machnetinc.ledger.core.common.Affiliate;
import com.machnetinc.ledger.core.common.UniqueId;

import java.util.UUID;

public class NodeTestData {

    public static Node userNode() {
        return new Node(
                "Test node",
                new Account("Test Account", AccountId.of(UniqueId.of(UUID.randomUUID()))),
                Node.NodeType.USER,
                Node.NodeStatus.CREATED,
                new Affiliate("", AccountId.of(UniqueId.of(UUID.randomUUID())))
        );
    }
}
