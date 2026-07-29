package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClassOperationDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassOperationDTO.class);
        ClassOperationDTO classOperationDTO1 = new ClassOperationDTO();
        classOperationDTO1.setId("id1");
        ClassOperationDTO classOperationDTO2 = new ClassOperationDTO();
        assertThat(classOperationDTO1).isNotEqualTo(classOperationDTO2);
        classOperationDTO2.setId(classOperationDTO1.getId());
        assertThat(classOperationDTO1).isEqualTo(classOperationDTO2);
        classOperationDTO2.setId("id2");
        assertThat(classOperationDTO1).isNotEqualTo(classOperationDTO2);
        classOperationDTO1.setId(null);
        assertThat(classOperationDTO1).isNotEqualTo(classOperationDTO2);
    }
}
