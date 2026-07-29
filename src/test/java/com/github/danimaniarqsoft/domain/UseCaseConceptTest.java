package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseActorRefTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseBusinessRuleTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseConceptTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseConditionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class UseCaseConceptTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseConcept.class);
        UseCaseConcept useCaseConcept1 = getUseCaseConceptSample1();
        UseCaseConcept useCaseConcept2 = new UseCaseConcept();
        assertThat(useCaseConcept1).isNotEqualTo(useCaseConcept2);

        useCaseConcept2.setId(useCaseConcept1.getId());
        assertThat(useCaseConcept1).isEqualTo(useCaseConcept2);

        useCaseConcept2 = getUseCaseConceptSample2();
        assertThat(useCaseConcept1).isNotEqualTo(useCaseConcept2);
    }

    @Test
    void primaryActorsTest() {
        UseCaseConcept useCaseConcept = getUseCaseConceptRandomSampleGenerator();
        UseCaseActorRef useCaseActorRefBack = getUseCaseActorRefRandomSampleGenerator();

        useCaseConcept.addPrimaryActors(useCaseActorRefBack);
        assertThat(useCaseConcept.getPrimaryActorses()).containsOnly(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getPrimaryUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.removePrimaryActors(useCaseActorRefBack);
        assertThat(useCaseConcept.getPrimaryActorses()).doesNotContain(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getPrimaryUseCaseConcept()).isNull();

        useCaseConcept.primaryActorses(new HashSet<>(Set.of(useCaseActorRefBack)));
        assertThat(useCaseConcept.getPrimaryActorses()).containsOnly(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getPrimaryUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.setPrimaryActorses(new HashSet<>());
        assertThat(useCaseConcept.getPrimaryActorses()).doesNotContain(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getPrimaryUseCaseConcept()).isNull();
    }

    @Test
    void secondaryActorsTest() {
        UseCaseConcept useCaseConcept = getUseCaseConceptRandomSampleGenerator();
        UseCaseActorRef useCaseActorRefBack = getUseCaseActorRefRandomSampleGenerator();

        useCaseConcept.addSecondaryActors(useCaseActorRefBack);
        assertThat(useCaseConcept.getSecondaryActorses()).containsOnly(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getSecondaryUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.removeSecondaryActors(useCaseActorRefBack);
        assertThat(useCaseConcept.getSecondaryActorses()).doesNotContain(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getSecondaryUseCaseConcept()).isNull();

        useCaseConcept.secondaryActorses(new HashSet<>(Set.of(useCaseActorRefBack)));
        assertThat(useCaseConcept.getSecondaryActorses()).containsOnly(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getSecondaryUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.setSecondaryActorses(new HashSet<>());
        assertThat(useCaseConcept.getSecondaryActorses()).doesNotContain(useCaseActorRefBack);
        assertThat(useCaseActorRefBack.getSecondaryUseCaseConcept()).isNull();
    }

    @Test
    void preconditionsTest() {
        UseCaseConcept useCaseConcept = getUseCaseConceptRandomSampleGenerator();
        UseCaseCondition useCaseConditionBack = getUseCaseConditionRandomSampleGenerator();

        useCaseConcept.addPreconditions(useCaseConditionBack);
        assertThat(useCaseConcept.getPreconditionses()).containsOnly(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPreconditionUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.removePreconditions(useCaseConditionBack);
        assertThat(useCaseConcept.getPreconditionses()).doesNotContain(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPreconditionUseCaseConcept()).isNull();

        useCaseConcept.preconditionses(new HashSet<>(Set.of(useCaseConditionBack)));
        assertThat(useCaseConcept.getPreconditionses()).containsOnly(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPreconditionUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.setPreconditionses(new HashSet<>());
        assertThat(useCaseConcept.getPreconditionses()).doesNotContain(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPreconditionUseCaseConcept()).isNull();
    }

    @Test
    void postconditionsTest() {
        UseCaseConcept useCaseConcept = getUseCaseConceptRandomSampleGenerator();
        UseCaseCondition useCaseConditionBack = getUseCaseConditionRandomSampleGenerator();

        useCaseConcept.addPostconditions(useCaseConditionBack);
        assertThat(useCaseConcept.getPostconditionses()).containsOnly(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPostconditionUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.removePostconditions(useCaseConditionBack);
        assertThat(useCaseConcept.getPostconditionses()).doesNotContain(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPostconditionUseCaseConcept()).isNull();

        useCaseConcept.postconditionses(new HashSet<>(Set.of(useCaseConditionBack)));
        assertThat(useCaseConcept.getPostconditionses()).containsOnly(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPostconditionUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.setPostconditionses(new HashSet<>());
        assertThat(useCaseConcept.getPostconditionses()).doesNotContain(useCaseConditionBack);
        assertThat(useCaseConditionBack.getPostconditionUseCaseConcept()).isNull();
    }

    @Test
    void businessRulesTest() {
        UseCaseConcept useCaseConcept = getUseCaseConceptRandomSampleGenerator();
        UseCaseBusinessRule useCaseBusinessRuleBack = getUseCaseBusinessRuleRandomSampleGenerator();

        useCaseConcept.addBusinessRules(useCaseBusinessRuleBack);
        assertThat(useCaseConcept.getBusinessRuleses()).containsOnly(useCaseBusinessRuleBack);
        assertThat(useCaseBusinessRuleBack.getUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.removeBusinessRules(useCaseBusinessRuleBack);
        assertThat(useCaseConcept.getBusinessRuleses()).doesNotContain(useCaseBusinessRuleBack);
        assertThat(useCaseBusinessRuleBack.getUseCaseConcept()).isNull();

        useCaseConcept.businessRuleses(new HashSet<>(Set.of(useCaseBusinessRuleBack)));
        assertThat(useCaseConcept.getBusinessRuleses()).containsOnly(useCaseBusinessRuleBack);
        assertThat(useCaseBusinessRuleBack.getUseCaseConcept()).isEqualTo(useCaseConcept);

        useCaseConcept.setBusinessRuleses(new HashSet<>());
        assertThat(useCaseConcept.getBusinessRuleses()).doesNotContain(useCaseBusinessRuleBack);
        assertThat(useCaseBusinessRuleBack.getUseCaseConcept()).isNull();
    }

    @Test
    void requirementUseCaseConceptsTest() {
        UseCaseConcept useCaseConcept = getUseCaseConceptRandomSampleGenerator();
        RequirementUseCaseConcepts requirementUseCaseConceptsBack = getRequirementUseCaseConceptsRandomSampleGenerator();

        useCaseConcept.setRequirementUseCaseConcepts(requirementUseCaseConceptsBack);
        assertThat(useCaseConcept.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConceptsBack);

        useCaseConcept.requirementUseCaseConcepts(null);
        assertThat(useCaseConcept.getRequirementUseCaseConcepts()).isNull();
    }
}
