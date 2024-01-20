package com.machnetinc.ledger.client;

import com.machnetinc.ledger.client.journal.JournalGrpcClient;
import com.machnetinc.ledger.client.journal.TransactionEventData;
import com.machnetinc.ledger.client.node.NodeEventData;
import com.machnetinc.ledger.client.node.NodeGrpcClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class EventObserverTest {

    @Mock
    private JournalGrpcClient journalGrpcClient;
    @Mock
    private NodeGrpcClient nodeGrpcClient;

    @InjectMocks
    private EventObserver sut;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void onCreateJournalEvent() {
        var txEvent = TransactionEventData.transactionEvent();
        sut.onCreateJournalEvent(txEvent);
        verify(journalGrpcClient).createJournal(txEvent);
    }

    @Test
    void onGetJournalEvent() {
        sut.onGetJournalEvent("123");
        verify(journalGrpcClient).getJournal("123");
    }

    @Test
    void onCreateNodeEvent() {
        var nodeEvent = NodeEventData.nodeEvent();
        sut.onCreateNodeEvent(nodeEvent);
        verify(nodeGrpcClient).createNode(nodeEvent);
    }


    @Test
    void onGetNodeEvent() {
        sut.onGetNodeEvent("123");
        verify(nodeGrpcClient).getNode("123");
    }
}