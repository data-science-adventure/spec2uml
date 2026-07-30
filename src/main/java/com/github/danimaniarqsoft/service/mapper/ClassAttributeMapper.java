package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassAttribute;
import com.github.danimaniarqsoft.service.dto.ClassAttributeDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link ClassAttribute} and DTO {@link ClassAttributeDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassAttributeMapper extends EntityMapper<ClassAttributeDTO, ClassAttribute> {}
