package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.ProjectStatisticsAsserts.*;
import static com.github.danimaniarqsoft.domain.ProjectStatisticsTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectStatisticsMapperTest {

    private ProjectStatisticsMapper projectStatisticsMapper;

    @BeforeEach
    void setUp() {
        projectStatisticsMapper = new ProjectStatisticsMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getProjectStatisticsSample1();
        var actual = projectStatisticsMapper.toEntity(projectStatisticsMapper.toDto(expected));
        assertProjectStatisticsAllPropertiesEquals(expected, actual);
    }
}
