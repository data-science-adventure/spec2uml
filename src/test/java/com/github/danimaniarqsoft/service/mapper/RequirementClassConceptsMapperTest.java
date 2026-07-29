package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.RequirementClassConceptsAsserts.*;
import static com.github.danimaniarqsoft.domain.RequirementClassConceptsTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequirementClassConceptsMapperTest {

    private RequirementClassConceptsMapper requirementClassConceptsMapper;

    @BeforeEach
    void setUp() {
        requirementClassConceptsMapper = new RequirementClassConceptsMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getRequirementClassConceptsSample1();
        var actual = requirementClassConceptsMapper.toEntity(requirementClassConceptsMapper.toDto(expected));
        assertRequirementClassConceptsAllPropertiesEquals(expected, actual);
    }
}
