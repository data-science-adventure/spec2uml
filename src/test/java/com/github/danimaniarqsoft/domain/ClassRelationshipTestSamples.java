package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class ClassRelationshipTestSamples {

    public static ClassRelationship getClassRelationshipSample1() {
        return new ClassRelationship()
            .id("id1")
            .source("source1")
            .target("target1")
            .type("type1")
            .sourceMultiplicity("sourceMultiplicity1")
            .targetMultiplicity("targetMultiplicity1")
            .label("label1");
    }

    public static ClassRelationship getClassRelationshipSample2() {
        return new ClassRelationship()
            .id("id2")
            .source("source2")
            .target("target2")
            .type("type2")
            .sourceMultiplicity("sourceMultiplicity2")
            .targetMultiplicity("targetMultiplicity2")
            .label("label2");
    }

    public static ClassRelationship getClassRelationshipRandomSampleGenerator() {
        return new ClassRelationship()
            .id(UUID.randomUUID().toString())
            .source(UUID.randomUUID().toString())
            .target(UUID.randomUUID().toString())
            .type(UUID.randomUUID().toString())
            .sourceMultiplicity(UUID.randomUUID().toString())
            .targetMultiplicity(UUID.randomUUID().toString())
            .label(UUID.randomUUID().toString());
    }
}
