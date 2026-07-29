package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OperationParameterDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(OperationParameterDTO.class);
        OperationParameterDTO operationParameterDTO1 = new OperationParameterDTO();
        operationParameterDTO1.setId("id1");
        OperationParameterDTO operationParameterDTO2 = new OperationParameterDTO();
        assertThat(operationParameterDTO1).isNotEqualTo(operationParameterDTO2);
        operationParameterDTO2.setId(operationParameterDTO1.getId());
        assertThat(operationParameterDTO1).isEqualTo(operationParameterDTO2);
        operationParameterDTO2.setId("id2");
        assertThat(operationParameterDTO1).isNotEqualTo(operationParameterDTO2);
        operationParameterDTO1.setId(null);
        assertThat(operationParameterDTO1).isNotEqualTo(operationParameterDTO2);
    }
}
