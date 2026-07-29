package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ClassOperationTestSamples.*;
import static com.github.danimaniarqsoft.domain.OperationParameterTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OperationParameterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OperationParameter.class);
        OperationParameter operationParameter1 = getOperationParameterSample1();
        OperationParameter operationParameter2 = new OperationParameter();
        assertThat(operationParameter1).isNotEqualTo(operationParameter2);

        operationParameter2.setId(operationParameter1.getId());
        assertThat(operationParameter1).isEqualTo(operationParameter2);

        operationParameter2 = getOperationParameterSample2();
        assertThat(operationParameter1).isNotEqualTo(operationParameter2);
    }

    @Test
    void classOperationTest() {
        OperationParameter operationParameter = getOperationParameterRandomSampleGenerator();
        ClassOperation classOperationBack = getClassOperationRandomSampleGenerator();

        operationParameter.setClassOperation(classOperationBack);
        assertThat(operationParameter.getClassOperation()).isEqualTo(classOperationBack);

        operationParameter.classOperation(null);
        assertThat(operationParameter.getClassOperation()).isNull();
    }
}
