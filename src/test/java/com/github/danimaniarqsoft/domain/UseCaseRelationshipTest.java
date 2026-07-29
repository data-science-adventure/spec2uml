package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseRelationshipTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseRelationshipTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseRelationship.class);
        UseCaseRelationship useCaseRelationship1 = getUseCaseRelationshipSample1();
        UseCaseRelationship useCaseRelationship2 = new UseCaseRelationship();
        assertThat(useCaseRelationship1).isNotEqualTo(useCaseRelationship2);

        useCaseRelationship2.setId(useCaseRelationship1.getId());
        assertThat(useCaseRelationship1).isEqualTo(useCaseRelationship2);

        useCaseRelationship2 = getUseCaseRelationshipSample2();
        assertThat(useCaseRelationship1).isNotEqualTo(useCaseRelationship2);
    }

    @Test
    void requirementUseCaseConceptsTest() {
        UseCaseRelationship useCaseRelationship = getUseCaseRelationshipRandomSampleGenerator();
        RequirementUseCaseConcepts requirementUseCaseConceptsBack = getRequirementUseCaseConceptsRandomSampleGenerator();

        useCaseRelationship.setRequirementUseCaseConcepts(requirementUseCaseConceptsBack);
        assertThat(useCaseRelationship.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConceptsBack);

        useCaseRelationship.requirementUseCaseConcepts(null);
        assertThat(useCaseRelationship.getRequirementUseCaseConcepts()).isNull();
    }
}
