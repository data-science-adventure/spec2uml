package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.UseCaseActorRefTestSamples.*;
import static com.github.danimaniarqsoft.domain.UseCaseConceptTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UseCaseActorRefTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UseCaseActorRef.class);
        UseCaseActorRef useCaseActorRef1 = getUseCaseActorRefSample1();
        UseCaseActorRef useCaseActorRef2 = new UseCaseActorRef();
        assertThat(useCaseActorRef1).isNotEqualTo(useCaseActorRef2);

        useCaseActorRef2.setId(useCaseActorRef1.getId());
        assertThat(useCaseActorRef1).isEqualTo(useCaseActorRef2);

        useCaseActorRef2 = getUseCaseActorRefSample2();
        assertThat(useCaseActorRef1).isNotEqualTo(useCaseActorRef2);
    }

    @Test
    void primaryUseCaseConceptTest() {
        UseCaseActorRef useCaseActorRef = getUseCaseActorRefRandomSampleGenerator();
        UseCaseConcept useCaseConceptBack = getUseCaseConceptRandomSampleGenerator();

        useCaseActorRef.setPrimaryUseCaseConcept(useCaseConceptBack);
        assertThat(useCaseActorRef.getPrimaryUseCaseConcept()).isEqualTo(useCaseConceptBack);

        useCaseActorRef.primaryUseCaseConcept(null);
        assertThat(useCaseActorRef.getPrimaryUseCaseConcept()).isNull();
    }

    @Test
    void secondaryUseCaseConceptTest() {
        UseCaseActorRef useCaseActorRef = getUseCaseActorRefRandomSampleGenerator();
        UseCaseConcept useCaseConceptBack = getUseCaseConceptRandomSampleGenerator();

        useCaseActorRef.setSecondaryUseCaseConcept(useCaseConceptBack);
        assertThat(useCaseActorRef.getSecondaryUseCaseConcept()).isEqualTo(useCaseConceptBack);

        useCaseActorRef.secondaryUseCaseConcept(null);
        assertThat(useCaseActorRef.getSecondaryUseCaseConcept()).isNull();
    }
}
