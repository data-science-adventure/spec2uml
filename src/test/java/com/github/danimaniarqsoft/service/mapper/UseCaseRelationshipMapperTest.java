package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.UseCaseRelationshipAsserts.*;
import static com.github.danimaniarqsoft.domain.UseCaseRelationshipTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseCaseRelationshipMapperTest {

    private UseCaseRelationshipMapper useCaseRelationshipMapper;

    @BeforeEach
    void setUp() {
        useCaseRelationshipMapper = new UseCaseRelationshipMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUseCaseRelationshipSample1();
        var actual = useCaseRelationshipMapper.toEntity(useCaseRelationshipMapper.toDto(expected));
        assertUseCaseRelationshipAllPropertiesEquals(expected, actual);
    }
}
