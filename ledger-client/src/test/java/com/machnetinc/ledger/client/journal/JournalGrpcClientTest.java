package com.machnetinc.ledger.client.journal;

import com.machnetinc.ledger.client.GrpcClient;
import com.machnetinc.ledger.porto.JournalGrpcServiceGrpc.JournalGrpcServiceBlockingStub;
import com.machnetinc.ledger.porto.JournalId;
import com.machnetinc.ledger.porto.JournalResponse;
import com.machnetinc.ledger.porto.TransactionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class JournalGrpcClientTest {

    @Mock
    private GrpcClient grpcClient;
    @InjectMocks
    private JournalGrpcClient sut;


    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void createJournal() {
        var stub = Mockito.mock(JournalGrpcServiceBlockingStub.class);
        when(grpcClient.getJournalStub()).thenReturn(stub);
        when(stub.createJournal(any(TransactionRequest.class)))
                .thenReturn(JournalResponse.newBuilder().build());

        var response = sut.createJournal(TransactionEventData.transactionEvent());
        assertThat(response).isNotNull();

        verify(grpcClient).getJournalStub();
        verify(stub).createJournal(any(TransactionRequest.class));
    }

    @Test
    void getJournal() {
        var stub = Mockito.mock(JournalGrpcServiceBlockingStub.class);
        when(grpcClient.getJournalStub()).thenReturn(stub);
        when(stub.getJournal(any(JournalId.class)))
                .thenReturn(JournalResponse.newBuilder().build());

        var response = sut.getJournal("123");
        assertThat(response).isNotNull();

        verify(grpcClient).getJournalStub();
        verify(stub).getJournal(any(JournalId.class));
    }
}