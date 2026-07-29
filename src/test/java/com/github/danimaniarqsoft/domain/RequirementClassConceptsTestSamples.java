package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class RequirementClassConceptsTestSamples {

    public static RequirementClassConcepts getRequirementClassConceptsSample1() {
        return new RequirementClassConcepts().id("id1");
    }

    public static RequirementClassConcepts getRequirementClassConceptsSample2() {
        return new RequirementClassConcepts().id("id2");
    }

    public static RequirementClassConcepts getRequirementClassConceptsRandomSampleGenerator() {
        return new RequirementClassConcepts().id(UUID.randomUUID().toString());
    }
}
