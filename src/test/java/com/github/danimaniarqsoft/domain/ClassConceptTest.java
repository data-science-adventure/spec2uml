package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ClassAttributeTestSamples.*;
import static com.github.danimaniarqsoft.domain.ClassConceptTestSamples.*;
import static com.github.danimaniarqsoft.domain.ClassOperationTestSamples.*;
import static com.github.danimaniarqsoft.domain.RequirementClassConceptsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ClassConceptTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassConcept.class);
        ClassConcept classConcept1 = getClassConceptSample1();
        ClassConcept classConcept2 = new ClassConcept();
        assertThat(classConcept1).isNotEqualTo(classConcept2);

        classConcept2.setId(classConcept1.getId());
        assertThat(classConcept1).isEqualTo(classConcept2);

        classConcept2 = getClassConceptSample2();
        assertThat(classConcept1).isNotEqualTo(classConcept2);
    }

    @Test
    void attributesTest() {
        ClassConcept classConcept = getClassConceptRandomSampleGenerator();
        ClassAttribute classAttributeBack = getClassAttributeRandomSampleGenerator();

        classConcept.addAttributes(classAttributeBack);
        assertThat(classConcept.getAttributeses()).containsOnly(classAttributeBack);
        assertThat(classAttributeBack.getClassConcept()).isEqualTo(classConcept);

        classConcept.removeAttributes(classAttributeBack);
        assertThat(classConcept.getAttributeses()).doesNotContain(classAttributeBack);
        assertThat(classAttributeBack.getClassConcept()).isNull();

        classConcept.attributeses(new HashSet<>(Set.of(classAttributeBack)));
        assertThat(classConcept.getAttributeses()).containsOnly(classAttributeBack);
        assertThat(classAttributeBack.getClassConcept()).isEqualTo(classConcept);

        classConcept.setAttributeses(new HashSet<>());
        assertThat(classConcept.getAttributeses()).doesNotContain(classAttributeBack);
        assertThat(classAttributeBack.getClassConcept()).isNull();
    }

    @Test
    void operationsTest() {
        ClassConcept classConcept = getClassConceptRandomSampleGenerator();
        ClassOperation classOperationBack = getClassOperationRandomSampleGenerator();

        classConcept.addOperations(classOperationBack);
        assertThat(classConcept.getOperationses()).containsOnly(classOperationBack);
        assertThat(classOperationBack.getClassConcept()).isEqualTo(classConcept);

        classConcept.removeOperations(classOperationBack);
        assertThat(classConcept.getOperationses()).doesNotContain(classOperationBack);
        assertThat(classOperationBack.getClassConcept()).isNull();

        classConcept.operationses(new HashSet<>(Set.of(classOperationBack)));
        assertThat(classConcept.getOperationses()).containsOnly(classOperationBack);
        assertThat(classOperationBack.getClassConcept()).isEqualTo(classConcept);

        classConcept.setOperationses(new HashSet<>());
        assertThat(classConcept.getOperationses()).doesNotContain(classOperationBack);
        assertThat(classOperationBack.getClassConcept()).isNull();
    }

    @Test
    void requirementClassConceptsTest() {
        ClassConcept classConcept = getClassConceptRandomSampleGenerator();
        RequirementClassConcepts requirementClassConceptsBack = getRequirementClassConceptsRandomSampleGenerator();

        classConcept.setRequirementClassConcepts(requirementClassConceptsBack);
        assertThat(classConcept.getRequirementClassConcepts()).isEqualTo(requirementClassConceptsBack);

        classConcept.requirementClassConcepts(null);
        assertThat(classConcept.getRequirementClassConcepts()).isNull();
    }
}
