package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts;
import com.github.danimaniarqsoft.service.dto.RequirementUseCaseConceptsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link RequirementUseCaseConcepts} and its DTO {@link RequirementUseCaseConceptsDTO}.
 */
@Mapper(componentModel = "spring")
public interface RequirementUseCaseConceptsMapper extends EntityMapper<RequirementUseCaseConceptsDTO, RequirementUseCaseConcepts> {}
