package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class ClassConceptTestSamples {

    public static ClassConcept getClassConceptSample1() {
        return new ClassConcept().id("id1").name("name1").stereotype("stereotype1");
    }

    public static ClassConcept getClassConceptSample2() {
        return new ClassConcept().id("id2").name("name2").stereotype("stereotype2");
    }

    public static ClassConcept getClassConceptRandomSampleGenerator() {
        return new ClassConcept()
            .id(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .stereotype(UUID.randomUUID().toString());
    }
}
