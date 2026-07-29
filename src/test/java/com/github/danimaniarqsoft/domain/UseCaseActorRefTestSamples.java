package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class UseCaseActorRefTestSamples {

    public static UseCaseActorRef getUseCaseActorRefSample1() {
        return new UseCaseActorRef().id("id1").actorName("actorName1");
    }

    public static UseCaseActorRef getUseCaseActorRefSample2() {
        return new UseCaseActorRef().id("id2").actorName("actorName2");
    }

    public static UseCaseActorRef getUseCaseActorRefRandomSampleGenerator() {
        return new UseCaseActorRef().id(UUID.randomUUID().toString()).actorName(UUID.randomUUID().toString());
    }
}
