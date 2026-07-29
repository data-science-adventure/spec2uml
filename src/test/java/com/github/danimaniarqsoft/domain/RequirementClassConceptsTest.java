package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ClassConceptTestSamples.*;
import static com.github.danimaniarqsoft.domain.ClassRelationshipTestSamples.*;
import static com.github.danimaniarqsoft.domain.RequirementClassConceptsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RequirementClassConceptsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RequirementClassConcepts.class);
        RequirementClassConcepts requirementClassConcepts1 = getRequirementClassConceptsSample1();
        RequirementClassConcepts requirementClassConcepts2 = new RequirementClassConcepts();
        assertThat(requirementClassConcepts1).isNotEqualTo(requirementClassConcepts2);

        requirementClassConcepts2.setId(requirementClassConcepts1.getId());
        assertThat(requirementClassConcepts1).isEqualTo(requirementClassConcepts2);

        requirementClassConcepts2 = getRequirementClassConceptsSample2();
        assertThat(requirementClassConcepts1).isNotEqualTo(requirementClassConcepts2);
    }

    @Test
    void hashCodeVerifier() {
        RequirementClassConcepts requirementClassConcepts = new RequirementClassConcepts();
        assertThat(requirementClassConcepts.hashCode()).isZero();

        RequirementClassConcepts requirementClassConcepts1 = getRequirementClassConceptsSample1();
        requirementClassConcepts.setId(requirementClassConcepts1.getId());
        assertThat(requirementClassConcepts).hasSameHashCodeAs(requirementClassConcepts1);
    }

    @Test
    void classesTest() {
        RequirementClassConcepts requirementClassConcepts = getRequirementClassConceptsRandomSampleGenerator();
        ClassConcept classConceptBack = getClassConceptRandomSampleGenerator();

        requirementClassConcepts.addClasses(classConceptBack);
        assertThat(requirementClassConcepts.getClasseses()).containsOnly(classConceptBack);
        assertThat(classConceptBack.getRequirementClassConcepts()).isEqualTo(requirementClassConcepts);

        requirementClassConcepts.removeClasses(classConceptBack);
        assertThat(requirementClassConcepts.getClasseses()).doesNotContain(classConceptBack);
        assertThat(classConceptBack.getRequirementClassConcepts()).isNull();

        requirementClassConcepts.classeses(new HashSet<>(Set.of(classConceptBack)));
        assertThat(requirementClassConcepts.getClasseses()).containsOnly(classConceptBack);
        assertThat(classConceptBack.getRequirementClassConcepts()).isEqualTo(requirementClassConcepts);

        requirementClassConcepts.setClasseses(new HashSet<>());
        assertThat(requirementClassConcepts.getClasseses()).doesNotContain(classConceptBack);
        assertThat(classConceptBack.getRequirementClassConcepts()).isNull();
    }

    @Test
    void relationshipsTest() {
        RequirementClassConcepts requirementClassConcepts = getRequirementClassConceptsRandomSampleGenerator();
        ClassRelationship classRelationshipBack = getClassRelationshipRandomSampleGenerator();

        requirementClassConcepts.addRelationships(classRelationshipBack);
        assertThat(requirementClassConcepts.getRelationshipses()).containsOnly(classRelationshipBack);
        assertThat(classRelationshipBack.getRequirementClassConcepts()).isEqualTo(requirementClassConcepts);

        requirementClassConcepts.removeRelationships(classRelationshipBack);
        assertThat(requirementClassConcepts.getRelationshipses()).doesNotContain(classRelationshipBack);
        assertThat(classRelationshipBack.getRequirementClassConcepts()).isNull();

        requirementClassConcepts.relationshipses(new HashSet<>(Set.of(classRelationshipBack)));
        assertThat(requirementClassConcepts.getRelationshipses()).containsOnly(classRelationshipBack);
        assertThat(classRelationshipBack.getRequirementClassConcepts()).isEqualTo(requirementClassConcepts);

        requirementClassConcepts.setRelationshipses(new HashSet<>());
        assertThat(requirementClassConcepts.getRelationshipses()).doesNotContain(classRelationshipBack);
        assertThat(classRelationshipBack.getRequirementClassConcepts()).isNull();
    }
}
