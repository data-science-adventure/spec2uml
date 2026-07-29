package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProjectStatisticsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProjectStatisticsDTO.class);
        ProjectStatisticsDTO projectStatisticsDTO1 = new ProjectStatisticsDTO();
        projectStatisticsDTO1.setId("id1");
        ProjectStatisticsDTO projectStatisticsDTO2 = new ProjectStatisticsDTO();
        assertThat(projectStatisticsDTO1).isNotEqualTo(projectStatisticsDTO2);
        projectStatisticsDTO2.setId(projectStatisticsDTO1.getId());
        assertThat(projectStatisticsDTO1).isEqualTo(projectStatisticsDTO2);
        projectStatisticsDTO2.setId("id2");
        assertThat(projectStatisticsDTO1).isNotEqualTo(projectStatisticsDTO2);
        projectStatisticsDTO1.setId(null);
        assertThat(projectStatisticsDTO1).isNotEqualTo(projectStatisticsDTO2);
    }
}
