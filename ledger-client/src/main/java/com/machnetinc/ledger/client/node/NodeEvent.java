package com.machnetinc.ledger.client.node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NodeEvent {

    private String name;
    private String accountId;
    private String type;
    private String affiliate;
}
