package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class ClassAttributeTestSamples {

    public static ClassAttribute getClassAttributeSample1() {
        return new ClassAttribute().id("id1").name("name1").type("type1").visibility("visibility1");
    }

    public static ClassAttribute getClassAttributeSample2() {
        return new ClassAttribute().id("id2").name("name2").type("type2").visibility("visibility2");
    }

    public static ClassAttribute getClassAttributeRandomSampleGenerator() {
        return new ClassAttribute()
            .id(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .type(UUID.randomUUID().toString())
            .visibility(UUID.randomUUID().toString());
    }
}
