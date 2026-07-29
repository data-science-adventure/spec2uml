package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.UseCaseBusinessRuleAsserts.*;
import static com.github.danimaniarqsoft.domain.UseCaseBusinessRuleTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UseCaseBusinessRuleMapperTest {

    private UseCaseBusinessRuleMapper useCaseBusinessRuleMapper;

    @BeforeEach
    void setUp() {
        useCaseBusinessRuleMapper = new UseCaseBusinessRuleMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getUseCaseBusinessRuleSample1();
        var actual = useCaseBusinessRuleMapper.toEntity(useCaseBusinessRuleMapper.toDto(expected));
        assertUseCaseBusinessRuleAllPropertiesEquals(expected, actual);
    }
}
