package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class ClassOperationTestSamples {

    public static ClassOperation getClassOperationSample1() {
        return new ClassOperation().id("id1").name("name1").returnType("returnType1");
    }

    public static ClassOperation getClassOperationSample2() {
        return new ClassOperation().id("id2").name("name2").returnType("returnType2");
    }

    public static ClassOperation getClassOperationRandomSampleGenerator() {
        return new ClassOperation()
            .id(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .returnType(UUID.randomUUID().toString());
    }
}
