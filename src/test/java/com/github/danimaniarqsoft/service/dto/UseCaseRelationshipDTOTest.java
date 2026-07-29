package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseRelationshipDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseRelationshipDTO.class);
        UseCaseRelationshipDTO useCaseRelationshipDTO1 = new UseCaseRelationshipDTO();
        useCaseRelationshipDTO1.setId("id1");
        UseCaseRelationshipDTO useCaseRelationshipDTO2 = new UseCaseRelationshipDTO();
        assertThat(useCaseRelationshipDTO1).isNotEqualTo(useCaseRelationshipDTO2);
        useCaseRelationshipDTO2.setId(useCaseRelationshipDTO1.getId());
        assertThat(useCaseRelationshipDTO1).isEqualTo(useCaseRelationshipDTO2);
        useCaseRelationshipDTO2.setId("id2");
        assertThat(useCaseRelationshipDTO1).isNotEqualTo(useCaseRelationshipDTO2);
        useCaseRelationshipDTO1.setId(null);
        assertThat(useCaseRelationshipDTO1).isNotEqualTo(useCaseRelationshipDTO2);
    }
}
