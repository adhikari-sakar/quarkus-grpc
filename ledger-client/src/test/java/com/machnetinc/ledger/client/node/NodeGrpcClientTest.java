package com.machnetinc.ledger.client.node;

import com.machnetinc.ledger.client.GrpcClient;
import com.machnetinc.ledger.porto.NodeId;
import com.machnetinc.ledger.porto.NodeRequest;
import com.machnetinc.ledger.porto.NodeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static com.machnetinc.ledger.porto.NodeGrpcServiceGrpc.NodeGrpcServiceBlockingStub;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class NodeGrpcClientTest {

    @Mock
    private GrpcClient grpcClient;
    @InjectMocks
    private NodeGrpcClient sut;


    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void createJournal() {
        var stub = Mockito.mock(NodeGrpcServiceBlockingStub.class);
        when(grpcClient.getNodeStub()).thenReturn(stub);
        when(stub.createNode(any(NodeRequest.class)))
                .thenReturn(NodeResponse.newBuilder().build());

        var response = sut.createNode(NodeEventData.nodeEvent());
        assertThat(response).isNotNull();

        verify(grpcClient).getNodeStub();
        verify(stub).createNode(any(NodeRequest.class));
    }

    @Test
    void getJournal() {
        var stub = Mockito.mock(NodeGrpcServiceBlockingStub.class);
        when(grpcClient.getNodeStub()).thenReturn(stub);
        when(stub.getNode(any(NodeId.class)))
                .thenReturn(NodeResponse.newBuilder().build());

        var response = sut.getNode("123");
        assertThat(response).isNotNull();

        verify(grpcClient).getNodeStub();
        verify(stub).getNode(any(NodeId.class));
    }
}