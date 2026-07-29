package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RequirementClassConceptsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RequirementClassConceptsDTO.class);
        RequirementClassConceptsDTO requirementClassConceptsDTO1 = new RequirementClassConceptsDTO();
        requirementClassConceptsDTO1.setId("id1");
        RequirementClassConceptsDTO requirementClassConceptsDTO2 = new RequirementClassConceptsDTO();
        assertThat(requirementClassConceptsDTO1).isNotEqualTo(requirementClassConceptsDTO2);
        requirementClassConceptsDTO2.setId(requirementClassConceptsDTO1.getId());
        assertThat(requirementClassConceptsDTO1).isEqualTo(requirementClassConceptsDTO2);
        requirementClassConceptsDTO2.setId("id2");
        assertThat(requirementClassConceptsDTO1).isNotEqualTo(requirementClassConceptsDTO2);
        requirementClassConceptsDTO1.setId(null);
        assertThat(requirementClassConceptsDTO1).isNotEqualTo(requirementClassConceptsDTO2);
    }
}
