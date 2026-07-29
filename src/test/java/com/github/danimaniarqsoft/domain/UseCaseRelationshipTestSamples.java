package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class UseCaseRelationshipTestSamples {

    public static UseCaseRelationship getUseCaseRelationshipSample1() {
        return new UseCaseRelationship().id("id1").source("source1").target("target1").type("type1").label("label1");
    }

    public static UseCaseRelationship getUseCaseRelationshipSample2() {
        return new UseCaseRelationship().id("id2").source("source2").target("target2").type("type2").label("label2");
    }

    public static UseCaseRelationship getUseCaseRelationshipRandomSampleGenerator() {
        return new UseCaseRelationship()
            .id(UUID.randomUUID().toString())
            .source(UUID.randomUUID().toString())
            .target(UUID.randomUUID().toString())
            .type(UUID.randomUUID().toString())
            .label(UUID.randomUUID().toString());
    }
}
