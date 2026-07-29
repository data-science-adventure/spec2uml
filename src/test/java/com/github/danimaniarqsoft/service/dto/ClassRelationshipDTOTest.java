package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClassRelationshipDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassRelationshipDTO.class);
        ClassRelationshipDTO classRelationshipDTO1 = new ClassRelationshipDTO();
        classRelationshipDTO1.setId("id1");
        ClassRelationshipDTO classRelationshipDTO2 = new ClassRelationshipDTO();
        assertThat(classRelationshipDTO1).isNotEqualTo(classRelationshipDTO2);
        classRelationshipDTO2.setId(classRelationshipDTO1.getId());
        assertThat(classRelationshipDTO1).isEqualTo(classRelationshipDTO2);
        classRelationshipDTO2.setId("id2");
        assertThat(classRelationshipDTO1).isNotEqualTo(classRelationshipDTO2);
        classRelationshipDTO1.setId(null);
        assertThat(classRelationshipDTO1).isNotEqualTo(classRelationshipDTO2);
    }
}
