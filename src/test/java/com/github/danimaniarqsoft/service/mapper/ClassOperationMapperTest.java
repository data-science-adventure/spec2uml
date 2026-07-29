package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.ClassOperationAsserts.*;
import static com.github.danimaniarqsoft.domain.ClassOperationTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassOperationMapperTest {

    private ClassOperationMapper classOperationMapper;

    @BeforeEach
    void setUp() {
        classOperationMapper = new ClassOperationMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getClassOperationSample1();
        var actual = classOperationMapper.toEntity(classOperationMapper.toDto(expected));
        assertClassOperationAllPropertiesEquals(expected, actual);
    }
}
