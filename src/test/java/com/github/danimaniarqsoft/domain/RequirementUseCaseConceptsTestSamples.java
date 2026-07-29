package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class RequirementUseCaseConceptsTestSamples {

    public static RequirementUseCaseConcepts getRequirementUseCaseConceptsSample1() {
        return new RequirementUseCaseConcepts().id("id1");
    }

    public static RequirementUseCaseConcepts getRequirementUseCaseConceptsSample2() {
        return new RequirementUseCaseConcepts().id("id2");
    }

    public static RequirementUseCaseConcepts getRequirementUseCaseConceptsRandomSampleGenerator() {
        return new RequirementUseCaseConcepts().id(UUID.randomUUID().toString());
    }
}
