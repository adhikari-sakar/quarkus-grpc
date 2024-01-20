package com.machnetinc.ledger.core.journal;

import com.machnetinc.ledger.core.common.UniqueId;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class JournalTest {

    private static final UniqueId<UUID> JOURNAL_ID = UniqueId.of(UUID.randomUUID());

    @Test
    void equalsAndHashCode_sameId_test() {
        var journal1 = JournalTestData.debitJournal();
        journal1.setId(JOURNAL_ID);
        var journal2 = JournalTestData.debitJournal();
        journal2.setId(JOURNAL_ID);

        assertThat(journal1).isEqualTo(journal2);
        assertThat(journal1.hashCode()).isEqualTo(journal2.hashCode());
    }

    @Test
    void equalsAndHashCode_differentId_test() {
        var journal1 = JournalTestData.debitJournal();
        journal1.setId(UniqueId.of(UUID.randomUUID()));
        var journal2 = JournalTestData.debitJournal();
        journal2.setId(UniqueId.of(UUID.randomUUID()));

        assertThat(journal1).isNotEqualTo(journal2);
        assertThat(journal1.hashCode()).isNotEqualTo(journal2.hashCode());
    }

}