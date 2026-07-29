package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.ClassRelationshipAsserts.*;
import static com.github.danimaniarqsoft.domain.ClassRelationshipTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassRelationshipMapperTest {

    private ClassRelationshipMapper classRelationshipMapper;

    @BeforeEach
    void setUp() {
        classRelationshipMapper = new ClassRelationshipMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getClassRelationshipSample1();
        var actual = classRelationshipMapper.toEntity(classRelationshipMapper.toDto(expected));
        assertClassRelationshipAllPropertiesEquals(expected, actual);
    }
}
