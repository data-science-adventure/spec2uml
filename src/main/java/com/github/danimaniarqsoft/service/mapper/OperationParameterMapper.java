package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassOperation;
import com.github.danimaniarqsoft.domain.OperationParameter;
import com.github.danimaniarqsoft.service.dto.ClassOperationDTO;
import com.github.danimaniarqsoft.service.dto.OperationParameterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OperationParameter} and its DTO {@link OperationParameterDTO}.
 */
@Mapper(componentModel = "spring")
public interface OperationParameterMapper extends EntityMapper<OperationParameterDTO, OperationParameter> {
    @Mapping(target = "classOperation", source = "classOperation", qualifiedByName = "classOperationId")
    OperationParameterDTO toDto(OperationParameter s);

    @Named("classOperationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClassOperationDTO toDtoClassOperationId(ClassOperation classOperation);
}
