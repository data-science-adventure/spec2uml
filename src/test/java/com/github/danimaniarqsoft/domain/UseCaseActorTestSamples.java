package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class UseCaseActorTestSamples {

    public static UseCaseActor getUseCaseActorSample1() {
        return new UseCaseActor().id("id1").name("name1");
    }

    public static UseCaseActor getUseCaseActorSample2() {
        return new UseCaseActor().id("id2").name("name2");
    }

    public static UseCaseActor getUseCaseActorRandomSampleGenerator() {
        return new UseCaseActor().id(UUID.randomUUID().toString()).name(UUID.randomUUID().toString());
    }
}
