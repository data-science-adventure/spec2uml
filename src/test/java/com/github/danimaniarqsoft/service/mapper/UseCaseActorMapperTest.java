package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.UseCaseActorAsserts.*;
import static com.github.danimaniarqsoft.domain.UseCaseActorTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseCaseActorMapperTest {

    private UseCaseActorMapper useCaseActorMapper;

    @BeforeEach
    void setUp() {
        useCaseActorMapper = new UseCaseActorMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUseCaseActorSample1();
        var actual = useCaseActorMapper.toEntity(useCaseActorMapper.toDto(expected));
        assertUseCaseActorAllPropertiesEquals(expected, actual);
    }
}
