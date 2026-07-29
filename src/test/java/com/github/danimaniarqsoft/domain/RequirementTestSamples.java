package com.github.danimaniarqsoft.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class RequirementTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + 2 * Short.MAX_VALUE);

    public static Requirement getRequirementSample1() {
        return new Requirement().id("id1").sentId(1).source("source1").projectId("projectId1").type("type1").specLevel("specLevel1");
    }

    public static Requirement getRequirementSample2() {
        return new Requirement().id("id2").sentId(2).source("source2").projectId("projectId2").type("type2").specLevel("specLevel2");
    }

    public static Requirement getRequirementRandomSampleGenerator() {
        return new Requirement()
            .id(UUID.randomUUID().toString())
            .sentId(intCount.incrementAndGet())
            .source(UUID.randomUUID().toString())
            .projectId(UUID.randomUUID().toString())
            .type(UUID.randomUUID().toString())
            .specLevel(UUID.randomUUID().toString());
    }
}
