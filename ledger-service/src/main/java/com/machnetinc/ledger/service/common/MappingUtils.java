package com.machnetinc.ledger.service.common;

import com.machnetinc.ledger.core.common.UniqueId;

import java.util.UUID;

import static java.util.Optional.ofNullable;

public class MappingUtils {

    public static UUID toUuid(UniqueId<UUID> uniqueId) {
        return ofNullable(uniqueId).map(UniqueId::getValue).orElseGet(UUID::randomUUID);
    }

    public static UniqueId<UUID> toUuid(UUID uuid) {
        return ofNullable(uuid).map(UniqueId::of).orElseGet(() -> UniqueId.of(uuid));
    }
}