package com.machnetinc.ledger.core.node;

import com.machnetinc.ledger.core.common.UniqueId;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {
    private static final UniqueId<UUID> NODE_ID = UniqueId.of(UUID.randomUUID());

    @Test
    void equalsAndHashCode_sameId_test() {
        var node1 = NodeTestData.userNode();
        node1.setId(NODE_ID);
        var node2 = NodeTestData.userNode();
        node2.setId(NODE_ID);

        assertThat(node1).isEqualTo(node2);
        assertThat(node1.hashCode()).isEqualTo(node2.hashCode());
    }

    @Test
    void equalsAndHashCode_differentId_test() {
        var node1 = NodeTestData.userNode();
        node1.setId(UniqueId.of(UUID.randomUUID()));
        var node2 = NodeTestData.userNode();
        node2.setId(UniqueId.of(UUID.randomUUID()));

        assertThat(node1).isNotEqualTo(node2);
        assertThat(node1.hashCode()).isNotEqualTo(node2.hashCode());
    }

}