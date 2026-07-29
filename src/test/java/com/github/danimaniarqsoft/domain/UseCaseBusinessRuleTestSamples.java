package com.github.danimaniarqsoft.domain;

import java.util.UUID;

public class UseCaseBusinessRuleTestSamples {

    public static UseCaseBusinessRule getUseCaseBusinessRuleSample1() {
        return new UseCaseBusinessRule().id("id1").ruleText("ruleText1");
    }

    public static UseCaseBusinessRule getUseCaseBusinessRuleSample2() {
        return new UseCaseBusinessRule().id("id2").ruleText("ruleText2");
    }

    public static UseCaseBusinessRule getUseCaseBusinessRuleRandomSampleGenerator() {
        return new UseCaseBusinessRule().id(UUID.randomUUID().toString()).ruleText(UUID.randomUUID().toString());
    }
}
