package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseActorTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseActorTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseActor.class);
        UseCaseActor useCaseActor1 = getUseCaseActorSample1();
        UseCaseActor useCaseActor2 = new UseCaseActor();
        assertThat(useCaseActor1).isNotEqualTo(useCaseActor2);

        useCaseActor2.setId(useCaseActor1.getId());
        assertThat(useCaseActor1).isEqualTo(useCaseActor2);

        useCaseActor2 = getUseCaseActorSample2();
        assertThat(useCaseActor1).isNotEqualTo(useCaseActor2);
    }

    @Test
    void requirementUseCaseConceptsTest() {
        UseCaseActor useCaseActor = getUseCaseActorRandomSampleGenerator();
        RequirementUseCaseConcepts requirementUseCaseConceptsBack = getRequirementUseCaseConceptsRandomSampleGenerator();

        useCaseActor.setRequirementUseCaseConcepts(requirementUseCaseConceptsBack);
        assertThat(useCaseActor.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConceptsBack);

        useCaseActor.requirementUseCaseConcepts(null);
        assertThat(useCaseActor.getRequirementUseCaseConcepts()).isNull();
    }
}
