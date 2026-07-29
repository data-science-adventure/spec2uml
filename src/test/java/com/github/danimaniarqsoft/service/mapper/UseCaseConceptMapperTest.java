package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.UseCaseConceptAsserts.*;
import static com.github.danimaniarqsoft.domain.UseCaseConceptTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseCaseConceptMapperTest {

    private UseCaseConceptMapper useCaseConceptMapper;

    @BeforeEach
    void setUp() {
        useCaseConceptMapper = new UseCaseConceptMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUseCaseConceptSample1();
        var actual = useCaseConceptMapper.toEntity(useCaseConceptMapper.toDto(expected));
        assertUseCaseConceptAllPropertiesEquals(expected, actual);
    }
}
