package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class ProjectTestSamples {

    public static Project getProjectSample1() {
        return new Project().id("id1").name("name1").umlVersion("umlVersion1");
    }

    public static Project getProjectSample2() {
        return new Project().id("id2").name("name2").umlVersion("umlVersion2");
    }

    public static Project getProjectRandomSampleGenerator() {
        return new Project().id(UUID.randomUUID().toString()).name(UUID.randomUUID().toString()).umlVersion(UUID.randomUUID().toString());
    }
}
