package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassRelationship;
import com.github.danimaniarqsoft.service.dto.ClassRelationshipDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link ClassRelationship} and DTO {@link ClassRelationshipDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassRelationshipMapper extends EntityMapper<ClassRelationshipDTO, ClassRelationship> {}
