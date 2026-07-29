package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseActorDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseActorDTO.class);
        UseCaseActorDTO useCaseActorDTO1 = new UseCaseActorDTO();
        useCaseActorDTO1.setId("id1");
        UseCaseActorDTO useCaseActorDTO2 = new UseCaseActorDTO();
        assertThat(useCaseActorDTO1).isNotEqualTo(useCaseActorDTO2);
        useCaseActorDTO2.setId(useCaseActorDTO1.getId());
        assertThat(useCaseActorDTO1).isEqualTo(useCaseActorDTO2);
        useCaseActorDTO2.setId("id2");
        assertThat(useCaseActorDTO1).isNotEqualTo(useCaseActorDTO2);
        useCaseActorDTO1.setId(null);
        assertThat(useCaseActorDTO1).isNotEqualTo(useCaseActorDTO2);
    }
}
