package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.UseCaseConditionAsserts.*;
import static com.github.danimaniarqsoft.domain.UseCaseConditionTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseCaseConditionMapperTest {

    private UseCaseConditionMapper useCaseConditionMapper;

    @BeforeEach
    void setUp() {
        useCaseConditionMapper = new UseCaseConditionMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUseCaseConditionSample1();
        var actual = useCaseConditionMapper.toEntity(useCaseConditionMapper.toDto(expected));
        assertUseCaseConditionAllPropertiesEquals(expected, actual);
    }
}
