package com.github.danimaniarqsoft.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ProjectStatisticsTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + 2 * Short.MAX_VALUE);

    public static ProjectStatistics getProjectStatisticsSample1() {
        return new ProjectStatistics().id("id1").requirements(1).completed(1).approved(1);
    }

    public static ProjectStatistics getProjectStatisticsSample2() {
        return new ProjectStatistics().id("id2").requirements(2).completed(2).approved(2);
    }

    public static ProjectStatistics getProjectStatisticsRandomSampleGenerator() {
        return new ProjectStatistics()
            .id(UUID.randomUUID().toString())
            .requirements(intCount.incrementAndGet())
            .completed(intCount.incrementAndGet())
            .approved(intCount.incrementAndGet());
    }
}
