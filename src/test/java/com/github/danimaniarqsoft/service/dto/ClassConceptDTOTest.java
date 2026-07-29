package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClassConceptDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassConceptDTO.class);
        ClassConceptDTO classConceptDTO1 = new ClassConceptDTO();
        classConceptDTO1.setId("id1");
        ClassConceptDTO classConceptDTO2 = new ClassConceptDTO();
        assertThat(classConceptDTO1).isNotEqualTo(classConceptDTO2);
        classConceptDTO2.setId(classConceptDTO1.getId());
        assertThat(classConceptDTO1).isEqualTo(classConceptDTO2);
        classConceptDTO2.setId("id2");
        assertThat(classConceptDTO1).isNotEqualTo(classConceptDTO2);
        classConceptDTO1.setId(null);
        assertThat(classConceptDTO1).isNotEqualTo(classConceptDTO2);
    }
}
