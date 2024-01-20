package com.machnetinc.ledger.core.common;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueIdTest {

    @Test
    void equalsAndHashCode_matches_same_string() {
        var uniqueId1 = UniqueId.of("id1");
        var uniqueId2 = UniqueId.of("id1");

        assertThat(uniqueId1).isEqualTo(uniqueId2);
        assertThat(uniqueId1.hashCode()).isEqualTo(uniqueId2.hashCode());
    }

    @Test
    void equalsAndHashCode_unMatches_different_string() {
        var uniqueId1 = UniqueId.of("id1");
        var uniqueId2 = UniqueId.of("id2");

        assertThat(uniqueId1).isNotEqualTo(uniqueId2);
        assertThat(uniqueId1.hashCode()).isNotEqualTo(uniqueId2.hashCode());
    }

    @Test
    void equalsAndHashCode_matches_same_UUID() {
        var uuid = UUID.randomUUID();
        var uniqueId1 = UniqueId.of(uuid);
        var uniqueId2 = UniqueId.of(uuid);

        assertThat(uniqueId1).isEqualTo(uniqueId2);
        assertThat(uniqueId1.hashCode()).isEqualTo(uniqueId2.hashCode());
    }

    @Test
    void equalsAndHashCode_unMatches_different_UUID() {
        var uniqueId1 = UniqueId.of(UUID.randomUUID());
        var uniqueId2 = UniqueId.of(UUID.randomUUID());

        assertThat(uniqueId1).isNotEqualTo(uniqueId2);
        assertThat(uniqueId1.hashCode()).isNotEqualTo(uniqueId2.hashCode());
    }

}