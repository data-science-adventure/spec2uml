package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseConditionDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseConditionDTO.class);
        UseCaseConditionDTO useCaseConditionDTO1 = new UseCaseConditionDTO();
        useCaseConditionDTO1.setId("id1");
        UseCaseConditionDTO useCaseConditionDTO2 = new UseCaseConditionDTO();
        assertThat(useCaseConditionDTO1).isNotEqualTo(useCaseConditionDTO2);
        useCaseConditionDTO2.setId(useCaseConditionDTO1.getId());
        assertThat(useCaseConditionDTO1).isEqualTo(useCaseConditionDTO2);
        useCaseConditionDTO2.setId("id2");
        assertThat(useCaseConditionDTO1).isNotEqualTo(useCaseConditionDTO2);
        useCaseConditionDTO1.setId(null);
        assertThat(useCaseConditionDTO1).isNotEqualTo(useCaseConditionDTO2);
    }
}
