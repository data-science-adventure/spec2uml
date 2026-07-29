package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.ClassConceptAsserts.*;
import static com.github.danimaniarqsoft.domain.ClassConceptTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassConceptMapperTest {

    private ClassConceptMapper classConceptMapper;

    @BeforeEach
    void setUp() {
        classConceptMapper = new ClassConceptMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getClassConceptSample1();
        var actual = classConceptMapper.toEntity(classConceptMapper.toDto(expected));
        assertClassConceptAllPropertiesEquals(expected, actual);
    }
}
