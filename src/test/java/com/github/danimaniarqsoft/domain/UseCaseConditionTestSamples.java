package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class UseCaseConditionTestSamples {

    public static UseCaseCondition getUseCaseConditionSample1() {
        return new UseCaseCondition().id("id1").conditionText("conditionText1");
    }

    public static UseCaseCondition getUseCaseConditionSample2() {
        return new UseCaseCondition().id("id2").conditionText("conditionText2");
    }

    public static UseCaseCondition getUseCaseConditionRandomSampleGenerator() {
        return new UseCaseCondition().id(UUID.randomUUID().toString()).conditionText(UUID.randomUUID().toString());
    }
}
