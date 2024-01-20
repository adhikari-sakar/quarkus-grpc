package com.machnetinc.ledger.service.node;

import com.machnetinc.ledger.core.common.UniqueId;
import com.machnetinc.ledger.core.node.NodeUseCase;
import com.machnetinc.ledger.porto.NodeGrpcServiceGrpc;
import com.machnetinc.ledger.porto.NodeId;
import com.machnetinc.ledger.porto.NodeRequest;
import com.machnetinc.ledger.porto.NodeResponse;
import com.machnetinc.ledger.service.interceptor.LogInterceptor;
import com.machnetinc.ledger.service.mapper.NodeMapper;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.RegisterInterceptor;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;

import java.util.UUID;

@GrpcService
@RegisterInterceptor(LogInterceptor.class)
public class NodeService extends NodeGrpcServiceGrpc.NodeGrpcServiceImplBase {

    @Inject
    NodeRepository nodeRepository;
    @Inject
    NodeMapper nodeMapper;
    @Inject
    NodeUseCase nodeUseCase;

    @Override
    @Blocking
    public void createNode(NodeRequest request, StreamObserver<NodeResponse> responseObserver) {
        responseObserver.onNext(applyUseCase(request));
        responseObserver.onCompleted();
    }

    private NodeResponse applyUseCase(NodeRequest request) {
        return nodeMapper.toResponse(nodeUseCase.apply(nodeMapper.toModel(request)));
    }

    @Override
    @Blocking
    public void getNode(NodeId request, StreamObserver<NodeResponse> responseObserver) {
        responseObserver.onNext(findNodeById(request));
        responseObserver.onCompleted();
    }

    private NodeResponse findNodeById(NodeId request) {
        return nodeRepository.findById(UniqueId.of(UUID.fromString(request.getId())))
                .map(nodeMapper::toResponse).orElseThrow();
    }
}
