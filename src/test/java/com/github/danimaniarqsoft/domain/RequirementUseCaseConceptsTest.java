package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseActorTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseConceptTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseRelationshipTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RequirementUseCaseConceptsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RequirementUseCaseConcepts.class);
        RequirementUseCaseConcepts requirementUseCaseConcepts1 = getRequirementUseCaseConceptsSample1();
        RequirementUseCaseConcepts requirementUseCaseConcepts2 = new RequirementUseCaseConcepts();
        assertThat(requirementUseCaseConcepts1).isNotEqualTo(requirementUseCaseConcepts2);

        requirementUseCaseConcepts2.setId(requirementUseCaseConcepts1.getId());
        assertThat(requirementUseCaseConcepts1).isEqualTo(requirementUseCaseConcepts2);

        requirementUseCaseConcepts2 = getRequirementUseCaseConceptsSample2();
        assertThat(requirementUseCaseConcepts1).isNotEqualTo(requirementUseCaseConcepts2);
    }

    @Test
    void hashCodeVerifier() {
        RequirementUseCaseConcepts requirementUseCaseConcepts = new RequirementUseCaseConcepts();
        assertThat(requirementUseCaseConcepts.hashCode()).isZero();

        RequirementUseCaseConcepts requirementUseCaseConcepts1 = getRequirementUseCaseConceptsSample1();
        requirementUseCaseConcepts.setId(requirementUseCaseConcepts1.getId());
        assertThat(requirementUseCaseConcepts).hasSameHashCodeAs(requirementUseCaseConcepts1);
    }

    @Test
    void actorsTest() {
        RequirementUseCaseConcepts requirementUseCaseConcepts = getRequirementUseCaseConceptsRandomSampleGenerator();
        UseCaseActor useCaseActorBack = getUseCaseActorRandomSampleGenerator();

        requirementUseCaseConcepts.addActors(useCaseActorBack);
        assertThat(requirementUseCaseConcepts.getActorses()).containsOnly(useCaseActorBack);
        assertThat(useCaseActorBack.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConcepts);

        requirementUseCaseConcepts.removeActors(useCaseActorBack);
        assertThat(requirementUseCaseConcepts.getActorses()).doesNotContain(useCaseActorBack);
        assertThat(useCaseActorBack.getRequirementUseCaseConcepts()).isNull();

        requirementUseCaseConcepts.actorses(new HashSet<>(Set.of(useCaseActorBack)));
        assertThat(requirementUseCaseConcepts.getActorses()).containsOnly(useCaseActorBack);
        assertThat(useCaseActorBack.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConcepts);

        requirementUseCaseConcepts.setActorses(new HashSet<>());
        assertThat(requirementUseCaseConcepts.getActorses()).doesNotContain(useCaseActorBack);
        assertThat(useCaseActorBack.getRequirementUseCaseConcepts()).isNull();
    }

    @Test
    void useCasesTest() {
        RequirementUseCaseConcepts requirementUseCaseConcepts = getRequirementUseCaseConceptsRandomSampleGenerator();
        UseCaseConcept useCaseConceptBack = getUseCaseConceptRandomSampleGenerator();

        requirementUseCaseConcepts.addUseCases(useCaseConceptBack);
        assertThat(requirementUseCaseConcepts.getUseCaseses()).containsOnly(useCaseConceptBack);
        assertThat(useCaseConceptBack.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConcepts);

        requirementUseCaseConcepts.removeUseCases(useCaseConceptBack);
        assertThat(requirementUseCaseConcepts.getUseCaseses()).doesNotContain(useCaseConceptBack);
        assertThat(useCaseConceptBack.getRequirementUseCaseConcepts()).isNull();

        requirementUseCaseConcepts.useCaseses(new HashSet<>(Set.of(useCaseConceptBack)));
        assertThat(requirementUseCaseConcepts.getUseCaseses()).containsOnly(useCaseConceptBack);
        assertThat(useCaseConceptBack.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConcepts);

        requirementUseCaseConcepts.setUseCaseses(new HashSet<>());
        assertThat(requirementUseCaseConcepts.getUseCaseses()).doesNotContain(useCaseConceptBack);
        assertThat(useCaseConceptBack.getRequirementUseCaseConcepts()).isNull();
    }

    @Test
    void relationshipsTest() {
        RequirementUseCaseConcepts requirementUseCaseConcepts = getRequirementUseCaseConceptsRandomSampleGenerator();
        UseCaseRelationship useCaseRelationshipBack = getUseCaseRelationshipRandomSampleGenerator();

        requirementUseCaseConcepts.addRelationships(useCaseRelationshipBack);
        assertThat(requirementUseCaseConcepts.getRelationshipses()).containsOnly(useCaseRelationshipBack);
        assertThat(useCaseRelationshipBack.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConcepts);

        requirementUseCaseConcepts.removeRelationships(useCaseRelationshipBack);
        assertThat(requirementUseCaseConcepts.getRelationshipses()).doesNotContain(useCaseRelationshipBack);
        assertThat(useCaseRelationshipBack.getRequirementUseCaseConcepts()).isNull();

        requirementUseCaseConcepts.relationshipses(new HashSet<>(Set.of(useCaseRelationshipBack)));
        assertThat(requirementUseCaseConcepts.getRelationshipses()).containsOnly(useCaseRelationshipBack);
        assertThat(useCaseRelationshipBack.getRequirementUseCaseConcepts()).isEqualTo(requirementUseCaseConcepts);

        requirementUseCaseConcepts.setRelationshipses(new HashSet<>());
        assertThat(requirementUseCaseConcepts.getRelationshipses()).doesNotContain(useCaseRelationshipBack);
        assertThat(useCaseRelationshipBack.getRequirementUseCaseConcepts()).isNull();
    }
}
