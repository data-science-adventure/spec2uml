package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClassAttributeDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassAttributeDTO.class);
        ClassAttributeDTO classAttributeDTO1 = new ClassAttributeDTO();
        classAttributeDTO1.setId("id1");
        ClassAttributeDTO classAttributeDTO2 = new ClassAttributeDTO();
        assertThat(classAttributeDTO1).isNotEqualTo(classAttributeDTO2);
        classAttributeDTO2.setId(classAttributeDTO1.getId());
        assertThat(classAttributeDTO1).isEqualTo(classAttributeDTO2);
        classAttributeDTO2.setId("id2");
        assertThat(classAttributeDTO1).isNotEqualTo(classAttributeDTO2);
        classAttributeDTO1.setId(null);
        assertThat(classAttributeDTO1).isNotEqualTo(classAttributeDTO2);
    }
}
