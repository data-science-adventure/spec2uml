package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ProjectTestSamples.*;
import static com.github.danimaniarqsoft.domain.RequirementClassConceptsTestSamples.*;
import static com.github.danimaniarqsoft.domain.RequirementTestSamples.*;
import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RequirementTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Requirement.class);
        Requirement requirement1 = getRequirementSample1();
        Requirement requirement2 = new Requirement();
        assertThat(requirement1).isNotEqualTo(requirement2);

        requirement2.setId(requirement1.getId());
        assertThat(requirement1).isEqualTo(requirement2);

        requirement2 = getRequirementSample2();
        assertThat(requirement1).isNotEqualTo(requirement2);
    }

    @Test
    void useCaseConceptsTest() {
        Requirement requirement = getRequirementRandomSampleGenerator();
        RequirementUseCaseConcepts requirementUseCaseConceptsBack = getRequirementUseCaseConceptsRandomSampleGenerator();

        requirement.setUseCaseConcepts(requirementUseCaseConceptsBack);
        assertThat(requirement.getUseCaseConcepts()).isEqualTo(requirementUseCaseConceptsBack);

        requirement.useCaseConcepts(null);
        assertThat(requirement.getUseCaseConcepts()).isNull();
    }

    @Test
    void classConceptsTest() {
        Requirement requirement = getRequirementRandomSampleGenerator();
        RequirementClassConcepts requirementClassConceptsBack = getRequirementClassConceptsRandomSampleGenerator();

        requirement.setClassConcepts(requirementClassConceptsBack);
        assertThat(requirement.getClassConcepts()).isEqualTo(requirementClassConceptsBack);

        requirement.classConcepts(null);
        assertThat(requirement.getClassConcepts()).isNull();
    }

    @Test
    void projectTest() {
        Requirement requirement = getRequirementRandomSampleGenerator();
        Project projectBack = getProjectRandomSampleGenerator();

        requirement.setProject(projectBack);
        assertThat(requirement.getProject()).isEqualTo(projectBack);

        requirement.project(null);
        assertThat(requirement.getProject()).isNull();
    }
}
