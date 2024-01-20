package com.machnetinc.ledger.service.config;

import com.machnetinc.ledger.core.journal.JournalUseCase;
import com.machnetinc.ledger.core.journal.JournalValidator;
import com.machnetinc.ledger.core.node.NodeUseCase;
import com.machnetinc.ledger.core.node.NodeValidator;
import com.machnetinc.ledger.service.journal.JournalRepository;
import com.machnetinc.ledger.service.node.NodeRepository;
import jakarta.enterprise.inject.Produces;


public class BeanConfig {

    @Produces
    public NodeValidator nodeValidator() {
        return new NodeValidator();
    }

    @Produces
    public JournalValidator journalValidator() {
        return new JournalValidator();
    }

    @Produces
    public JournalUseCase journalUseCase(JournalValidator journalValidator, JournalRepository journalRepository) {
        return new JournalUseCase(journalValidator, journalRepository);
    }

    @Produces
    public NodeUseCase nodeUseCase(NodeValidator nodeValidator, NodeRepository nodeRepository) {
        return new NodeUseCase(nodeValidator, nodeRepository);
    }
}
