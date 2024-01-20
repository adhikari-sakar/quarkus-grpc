package com.machnetinc.ledger.client;

import com.machnetinc.ledger.client.journal.JournalGrpcClient;
import com.machnetinc.ledger.client.journal.TransactionEvent;
import com.machnetinc.ledger.client.node.NodeEvent;
import com.machnetinc.ledger.client.node.NodeGrpcClient;
import com.machnetinc.ledger.porto.JournalResponse;
import com.machnetinc.ledger.porto.NodeResponse;
import jakarta.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class EventObserver {

    @Inject
    JournalGrpcClient journalGrpcClient;
    @Inject
    NodeGrpcClient nodeGrpcClient;


    public JournalResponse onCreateJournalEvent(@Observes TransactionEvent event) {
        return journalGrpcClient.createJournal(event);
    }

    public JournalResponse onGetJournalEvent(@Observes String journalId) {
        return journalGrpcClient.getJournal(journalId);
    }

    public NodeResponse onCreateNodeEvent(@Observes NodeEvent event) {
        return nodeGrpcClient.createNode(event);
    }

    public NodeResponse onGetNodeEvent(@Observes String nodeId) {
        return nodeGrpcClient.getNode(nodeId);
    }
}
