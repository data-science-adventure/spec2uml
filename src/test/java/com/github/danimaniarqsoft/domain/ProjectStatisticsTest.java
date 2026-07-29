package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ProjectStatisticsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProjectStatisticsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProjectStatistics.class);
        ProjectStatistics projectStatistics1 = getProjectStatisticsSample1();
        ProjectStatistics projectStatistics2 = new ProjectStatistics();
        assertThat(projectStatistics1).isNotEqualTo(projectStatistics2);

        projectStatistics2.setId(projectStatistics1.getId());
        assertThat(projectStatistics1).isEqualTo(projectStatistics2);

        projectStatistics2 = getProjectStatisticsSample2();
        assertThat(projectStatistics1).isNotEqualTo(projectStatistics2);
    }
}
