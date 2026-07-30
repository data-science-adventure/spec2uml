package com.github.danimaniarqsoft.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseActorRefDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseActorRefDTO.class);
        UseCaseActorRefDTO useCaseActorRefDTO1 = new UseCaseActorRefDTO();
        UseCaseActorRefDTO useCaseActorRefDTO2 = new UseCaseActorRefDTO();
        assertThat(useCaseActorRefDTO1).isNotEqualTo(useCaseActorRefDTO2);
        assertThat(useCaseActorRefDTO1).isEqualTo(useCaseActorRefDTO2);
        assertThat(useCaseActorRefDTO1).isNotEqualTo(useCaseActorRefDTO2);
        assertThat(useCaseActorRefDTO1).isNotEqualTo(useCaseActorRefDTO2);
    }
}
