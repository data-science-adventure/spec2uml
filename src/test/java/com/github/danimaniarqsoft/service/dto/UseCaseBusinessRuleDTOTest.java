package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseBusinessRuleDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseBusinessRuleDTO.class);
        UseCaseBusinessRuleDTO useCaseBusinessRuleDTO1 = new UseCaseBusinessRuleDTO();
        useCaseBusinessRuleDTO1.setId("id1");
        UseCaseBusinessRuleDTO useCaseBusinessRuleDTO2 = new UseCaseBusinessRuleDTO();
        assertThat(useCaseBusinessRuleDTO1).isNotEqualTo(useCaseBusinessRuleDTO2);
        useCaseBusinessRuleDTO2.setId(useCaseBusinessRuleDTO1.getId());
        assertThat(useCaseBusinessRuleDTO1).isEqualTo(useCaseBusinessRuleDTO2);
        useCaseBusinessRuleDTO2.setId("id2");
        assertThat(useCaseBusinessRuleDTO1).isNotEqualTo(useCaseBusinessRuleDTO2);
        useCaseBusinessRuleDTO1.setId(null);
        assertThat(useCaseBusinessRuleDTO1).isNotEqualTo(useCaseBusinessRuleDTO2);
    }
}
