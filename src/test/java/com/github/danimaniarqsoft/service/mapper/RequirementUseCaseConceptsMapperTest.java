package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsAsserts.*;
import static com.github.danimaniarqsoft.domain.RequirementUseCaseConceptsTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequirementUseCaseConceptsMapperTest {

    private RequirementUseCaseConceptsMapper requirementUseCaseConceptsMapper;

    @BeforeEach
    void setUp() {
        requirementUseCaseConceptsMapper = new RequirementUseCaseConceptsMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getRequirementUseCaseConceptsSample1();
        var actual = requirementUseCaseConceptsMapper.toEntity(requirementUseCaseConceptsMapper.toDto(expected));
        assertRequirementUseCaseConceptsAllPropertiesEquals(expected, actual);
    }
}
