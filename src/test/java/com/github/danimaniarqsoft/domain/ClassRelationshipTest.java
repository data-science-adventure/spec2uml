package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ClassRelationshipTestSamples.*;
import static com.github.danimaniarqsoft.domain.RequirementClassConceptsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClassRelationshipTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassRelationship.class);
        ClassRelationship classRelationship1 = getClassRelationshipSample1();
        ClassRelationship classRelationship2 = new ClassRelationship();
        assertThat(classRelationship1).isNotEqualTo(classRelationship2);

        classRelationship2.setId(classRelationship1.getId());
        assertThat(classRelationship1).isEqualTo(classRelationship2);

        classRelationship2 = getClassRelationshipSample2();
        assertThat(classRelationship1).isNotEqualTo(classRelationship2);
    }

    @Test
    void requirementClassConceptsTest() {
        ClassRelationship classRelationship = getClassRelationshipRandomSampleGenerator();
        RequirementClassConcepts requirementClassConceptsBack = getRequirementClassConceptsRandomSampleGenerator();

        classRelationship.setRequirementClassConcepts(requirementClassConceptsBack);
        assertThat(classRelationship.getRequirementClassConcepts()).isEqualTo(requirementClassConceptsBack);

        classRelationship.requirementClassConcepts(null);
        assertThat(classRelationship.getRequirementClassConcepts()).isNull();
    }
}
