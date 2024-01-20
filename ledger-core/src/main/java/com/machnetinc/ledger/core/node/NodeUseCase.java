package com.machnetinc.ledger.core.node;

import com.machnetinc.ledger.core.contracts.BaseRepository;
import com.machnetinc.ledger.core.contracts.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NodeUseCase implements UseCase<Node, Node> {

    private final NodeValidator validator;
    private final BaseRepository<Node> repository;

    @Override
    public Node apply(Node node) {
        return node.validate(List.of(validator))
                .andThen(repository::save);
    }
}
