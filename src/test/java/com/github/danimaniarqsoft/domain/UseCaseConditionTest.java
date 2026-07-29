package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.UseCaseConceptTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseConditionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseConditionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseCondition.class);
        UseCaseCondition useCaseCondition1 = getUseCaseConditionSample1();
        UseCaseCondition useCaseCondition2 = new UseCaseCondition();
        assertThat(useCaseCondition1).isNotEqualTo(useCaseCondition2);

        useCaseCondition2.setId(useCaseCondition1.getId());
        assertThat(useCaseCondition1).isEqualTo(useCaseCondition2);

        useCaseCondition2 = getUseCaseConditionSample2();
        assertThat(useCaseCondition1).isNotEqualTo(useCaseCondition2);
    }

    @Test
    void preconditionUseCaseConceptTest() {
        UseCaseCondition useCaseCondition = getUseCaseConditionRandomSampleGenerator();
        UseCaseConcept useCaseConceptBack = getUseCaseConceptRandomSampleGenerator();

        useCaseCondition.setPreconditionUseCaseConcept(useCaseConceptBack);
        assertThat(useCaseCondition.getPreconditionUseCaseConcept()).isEqualTo(useCaseConceptBack);

        useCaseCondition.preconditionUseCaseConcept(null);
        assertThat(useCaseCondition.getPreconditionUseCaseConcept()).isNull();
    }

    @Test
    void postconditionUseCaseConceptTest() {
        UseCaseCondition useCaseCondition = getUseCaseConditionRandomSampleGenerator();
        UseCaseConcept useCaseConceptBack = getUseCaseConceptRandomSampleGenerator();

        useCaseCondition.setPostconditionUseCaseConcept(useCaseConceptBack);
        assertThat(useCaseCondition.getPostconditionUseCaseConcept()).isEqualTo(useCaseConceptBack);

        useCaseCondition.postconditionUseCaseConcept(null);
        assertThat(useCaseCondition.getPostconditionUseCaseConcept()).isNull();
    }
}
