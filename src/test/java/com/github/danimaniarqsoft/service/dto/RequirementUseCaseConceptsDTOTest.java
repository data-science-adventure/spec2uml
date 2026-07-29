package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RequirementUseCaseConceptsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RequirementUseCaseConceptsDTO.class);
        RequirementUseCaseConceptsDTO requirementUseCaseConceptsDTO1 = new RequirementUseCaseConceptsDTO();
        requirementUseCaseConceptsDTO1.setId("id1");
        RequirementUseCaseConceptsDTO requirementUseCaseConceptsDTO2 = new RequirementUseCaseConceptsDTO();
        assertThat(requirementUseCaseConceptsDTO1).isNotEqualTo(requirementUseCaseConceptsDTO2);
        requirementUseCaseConceptsDTO2.setId(requirementUseCaseConceptsDTO1.getId());
        assertThat(requirementUseCaseConceptsDTO1).isEqualTo(requirementUseCaseConceptsDTO2);
        requirementUseCaseConceptsDTO2.setId("id2");
        assertThat(requirementUseCaseConceptsDTO1).isNotEqualTo(requirementUseCaseConceptsDTO2);
        requirementUseCaseConceptsDTO1.setId(null);
        assertThat(requirementUseCaseConceptsDTO1).isNotEqualTo(requirementUseCaseConceptsDTO2);
    }
}
