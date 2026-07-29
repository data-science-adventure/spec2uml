package com.github.danimaniarqsoft.service.mapper;

import static com.github.danimaniarqsoft.domain.OperationParameterAsserts.*;
import static com.github.danimaniarqsoft.domain.OperationParameterTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationParameterMapperTest {

    private OperationParameterMapper operationParameterMapper;

    @BeforeEach
    void setUp() {
        operationParameterMapper = new OperationParameterMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOperationParameterSample1();
        var actual = operationParameterMapper.toEntity(operationParameterMapper.toDto(expected));
        assertOperationParameterAllPropertiesEquals(expected, actual);
    }
}
