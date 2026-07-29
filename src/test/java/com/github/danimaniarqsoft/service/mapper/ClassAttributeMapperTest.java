package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.ClassAttributeAsserts.*;
import static com.github.danimaniarqsoft.domain.ClassAttributeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassAttributeMapperTest {

    private ClassAttributeMapper classAttributeMapper;

    @BeforeEach
    void setUp() {
        classAttributeMapper = new ClassAttributeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getClassAttributeSample1();
        var actual = classAttributeMapper.toEntity(classAttributeMapper.toDto(expected));
        assertClassAttributeAllPropertiesEquals(expected, actual);
    }
}
