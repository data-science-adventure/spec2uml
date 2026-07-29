package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseConceptDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseConceptDTO.class);
        UseCaseConceptDTO useCaseConceptDTO1 = new UseCaseConceptDTO();
        useCaseConceptDTO1.setId("id1");
        UseCaseConceptDTO useCaseConceptDTO2 = new UseCaseConceptDTO();
        assertThat(useCaseConceptDTO1).isNotEqualTo(useCaseConceptDTO2);
        useCaseConceptDTO2.setId(useCaseConceptDTO1.getId());
        assertThat(useCaseConceptDTO1).isEqualTo(useCaseConceptDTO2);
        useCaseConceptDTO2.setId("id2");
        assertThat(useCaseConceptDTO1).isNotEqualTo(useCaseConceptDTO2);
        useCaseConceptDTO1.setId(null);
        assertThat(useCaseConceptDTO1).isNotEqualTo(useCaseConceptDTO2);
    }
}
