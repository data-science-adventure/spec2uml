package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ClassConceptTestSamples.*;
import static com.github.danimaniarqsoft.domain.ClassOperationTestSamples.*;
import static com.github.danimaniarqsoft.domain.OperationParameterTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ClassOperationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassOperation.class);
        ClassOperation classOperation1 = getClassOperationSample1();
        ClassOperation classOperation2 = new ClassOperation();
        assertThat(classOperation1).isNotEqualTo(classOperation2);

        classOperation2.setId(classOperation1.getId());
        assertThat(classOperation1).isEqualTo(classOperation2);

        classOperation2 = getClassOperationSample2();
        assertThat(classOperation1).isNotEqualTo(classOperation2);
    }

    @Test
    void parametersTest() {
        ClassOperation classOperation = getClassOperationRandomSampleGenerator();
        OperationParameter operationParameterBack = getOperationParameterRandomSampleGenerator();

        classOperation.addParameters(operationParameterBack);
        assertThat(classOperation.getParameterses()).containsOnly(operationParameterBack);
        assertThat(operationParameterBack.getClassOperation()).isEqualTo(classOperation);

        classOperation.removeParameters(operationParameterBack);
        assertThat(classOperation.getParameterses()).doesNotContain(operationParameterBack);
        assertThat(operationParameterBack.getClassOperation()).isNull();

        classOperation.parameterses(new HashSet<>(Set.of(operationParameterBack)));
        assertThat(classOperation.getParameterses()).containsOnly(operationParameterBack);
        assertThat(operationParameterBack.getClassOperation()).isEqualTo(classOperation);

        classOperation.setParameterses(new HashSet<>());
        assertThat(classOperation.getParameterses()).doesNotContain(operationParameterBack);
        assertThat(operationParameterBack.getClassOperation()).isNull();
    }

    @Test
    void classConceptTest() {
        ClassOperation classOperation = getClassOperationRandomSampleGenerator();
        ClassConcept classConceptBack = getClassConceptRandomSampleGenerator();

        classOperation.setClassConcept(classConceptBack);
        assertThat(classOperation.getClassConcept()).isEqualTo(classConceptBack);

        classOperation.classConcept(null);
        assertThat(classOperation.getClassConcept()).isNull();
    }
}
