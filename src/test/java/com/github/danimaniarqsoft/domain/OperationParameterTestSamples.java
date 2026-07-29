package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class OperationParameterTestSamples {

    public static OperationParameter getOperationParameterSample1() {
        return new OperationParameter().id("id1").paramName("paramName1");
    }

    public static OperationParameter getOperationParameterSample2() {
        return new OperationParameter().id("id2").paramName("paramName2");
    }

    public static OperationParameter getOperationParameterRandomSampleGenerator() {
        return new OperationParameter().id(UUID.randomUUID().toString()).paramName(UUID.randomUUID().toString());
    }
}
