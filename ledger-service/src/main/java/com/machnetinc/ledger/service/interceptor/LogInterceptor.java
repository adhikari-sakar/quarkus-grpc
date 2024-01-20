package com.machnetinc.ledger.service.interceptor;

import io.grpc.*;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;


@ApplicationScoped
@Slf4j
public class LogInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        ServerCall<ReqT, RespT> listener = new ForwardingServerCall.SimpleForwardingServerCall<>(serverCall) {
            @Override
            public void sendMessage(RespT message) {
                log.info("[Sending message] {}", message.toString().replaceAll("\n", " "));
                super.sendMessage(message);
            }
        };

        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(serverCallHandler.startCall(listener, metadata)) {
            @Override
            public void onMessage(ReqT message) {
                log.info("[Received message] {}", message.toString().replaceAll("\n", " "));
                super.onMessage(message);
            }
        };
    }
}