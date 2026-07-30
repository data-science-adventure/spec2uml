package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.UseCaseRelationship;
import com.github.danimaniarqsoft.service.dto.UseCaseRelationshipDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link UseCaseRelationship} and DTO {@link UseCaseRelationshipDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseRelationshipMapper extends EntityMapper<UseCaseRelationshipDTO, UseCaseRelationship> {}
