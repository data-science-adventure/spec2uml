package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassOperation;
import com.github.danimaniarqsoft.service.dto.ClassOperationDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link ClassOperation} and DTO {@link ClassOperationDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassOperationMapper extends EntityMapper<ClassOperationDTO, ClassOperation> {}
