package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class UseCaseConceptTestSamples {

    public static UseCaseConcept getUseCaseConceptSample1() {
        return new UseCaseConcept().id("id1").name("name1").trigger("trigger1").systemBoundary("systemBoundary1");
    }

    public static UseCaseConcept getUseCaseConceptSample2() {
        return new UseCaseConcept().id("id2").name("name2").trigger("trigger2").systemBoundary("systemBoundary2");
    }

    public static UseCaseConcept getUseCaseConceptRandomSampleGenerator() {
        return new UseCaseConcept()
            .id(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .trigger(UUID.randomUUID().toString())
            .systemBoundary(UUID.randomUUID().toString());
    }
}
