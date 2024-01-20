package com.machnetinc.ledger.client.journal;

import com.machnetinc.ledger.client.GrpcClient;
import com.machnetinc.ledger.porto.JournalId;
import com.machnetinc.ledger.porto.JournalResponse;
import com.machnetinc.ledger.porto.TransactionRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JournalGrpcClient {

    @Inject
    GrpcClient grpcClient;

    public JournalResponse createJournal(TransactionEvent msg) {
        final TransactionRequest request = buildRequest(msg);
        return grpcClient.getJournalStub().createJournal(request);
    }

    public JournalResponse getJournal(String journalId) {
        return grpcClient.getJournalStub().getJournal(JournalId.newBuilder().setId(journalId).build());
    }

    private TransactionRequest buildRequest(TransactionEvent msg) {
        return TransactionRequest.newBuilder()
                .setUserId(msg.getUserId())
                .setAssociatedUser(msg.getAssociatedUser())
                .setUserFundingAccount(msg.getUserFundingAccount())
                .setAssociatedUserAccount(msg.getAssociatedUserAccount())
                .setSenderCurrency(msg.getSenderCurrency())
                .setRecipientCurrency(msg.getRecipientCurrency())
                .setExchangeRate(msg.getExchangeRate().doubleValue())
                .setSenderAmount(msg.getSenderAmount().doubleValue())
                .setTotalSenderAmount(msg.getTotalSenderAmount().doubleValue())
                .setFeeAmount(msg.getFeeAmount().doubleValue())
                .setBonusAmount(msg.getBonusAmount().doubleValue())
                .build();
    }

}
