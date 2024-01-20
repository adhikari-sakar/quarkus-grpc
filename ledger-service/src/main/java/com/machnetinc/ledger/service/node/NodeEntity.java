package com.machnetinc.ledger.service.node;

import com.machnetinc.ledger.core.node.Node.NodeStatus;
import com.machnetinc.ledger.core.node.Node.NodeType;
import com.machnetinc.ledger.service.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity(name = "NODE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NodeEntity extends BaseEntity {

    @Column(name = "node_name")
    private String name;

    @Column(name = "account_id")
    private String accountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "node_type")
    private NodeType type;

    @Column(name = "affiliate")
    private String affiliate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private NodeStatus status;
}
