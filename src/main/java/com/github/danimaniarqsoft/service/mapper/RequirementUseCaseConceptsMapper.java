package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts;
import com.github.danimaniarqsoft.service.dto.RequirementUseCaseConceptsDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link RequirementUseCaseConcepts} and DTO {@link RequirementUseCaseConceptsDTO}.
 */
@Mapper(componentModel = "spring", uses = { UseCaseActorMapper.class, UseCaseConceptMapper.class, UseCaseRelationshipMapper.class })
public interface RequirementUseCaseConceptsMapper extends EntityMapper<RequirementUseCaseConceptsDTO, RequirementUseCaseConcepts> {}
