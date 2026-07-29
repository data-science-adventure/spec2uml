package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.UseCaseActorRefAsserts.*;
import static com.github.danimaniarqsoft.domain.UseCaseActorRefTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseCaseActorRefMapperTest {

    private UseCaseActorRefMapper useCaseActorRefMapper;

    @BeforeEach
    void setUp() {
        useCaseActorRefMapper = new UseCaseActorRefMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUseCaseActorRefSample1();
        var actual = useCaseActorRefMapper.toEntity(useCaseActorRefMapper.toDto(expected));
        assertUseCaseActorRefAllPropertiesEquals(expected, actual);
    }
}
