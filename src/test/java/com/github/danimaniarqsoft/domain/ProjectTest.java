package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ProjectStatisticsTestSamples.*;
import static com.github.danimaniarqsoft.domain.ProjectTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProjectTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Project.class);
        Project project1 = getProjectSample1();
        Project project2 = new Project();
        assertThat(project1).isNotEqualTo(project2);

        project2.setId(project1.getId());
        assertThat(project1).isEqualTo(project2);

        project2 = getProjectSample2();
        assertThat(project1).isNotEqualTo(project2);
    }

    @Test
    void statisticsTest() {
        Project project = getProjectRandomSampleGenerator();
        ProjectStatistics projectStatisticsBack = getProjectStatisticsRandomSampleGenerator();

        project.setStatistics(projectStatisticsBack);
        assertThat(project.getStatistics()).isEqualTo(projectStatisticsBack);

        project.statistics(null);
        assertThat(project.getStatistics()).isNull();
    }
}
