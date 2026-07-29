package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.UseCaseBusinessRuleTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseConceptTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseBusinessRuleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseBusinessRule.class);
        UseCaseBusinessRule useCaseBusinessRule1 = getUseCaseBusinessRuleSample1();
        UseCaseBusinessRule useCaseBusinessRule2 = new UseCaseBusinessRule();
        assertThat(useCaseBusinessRule1).isNotEqualTo(useCaseBusinessRule2);

        useCaseBusinessRule2.setId(useCaseBusinessRule1.getId());
        assertThat(useCaseBusinessRule1).isEqualTo(useCaseBusinessRule2);

        useCaseBusinessRule2 = getUseCaseBusinessRuleSample2();
        assertThat(useCaseBusinessRule1).isNotEqualTo(useCaseBusinessRule2);
    }

    @Test
    void useCaseConceptTest() {
        UseCaseBusinessRule useCaseBusinessRule = getUseCaseBusinessRuleRandomSampleGenerator();
        UseCaseConcept useCaseConceptBack = getUseCaseConceptRandomSampleGenerator();

        useCaseBusinessRule.setUseCaseConcept(useCaseConceptBack);
        assertThat(useCaseBusinessRule.getUseCaseConcept()).isEqualTo(useCaseConceptBack);

        useCaseBusinessRule.useCaseConcept(null);
        assertThat(useCaseBusinessRule.getUseCaseConcept()).isNull();
    }
}
