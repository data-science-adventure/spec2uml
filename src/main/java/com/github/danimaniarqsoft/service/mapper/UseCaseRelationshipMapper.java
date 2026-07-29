package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts;
import com.github.danimaniarqsoft.domain.UseCaseRelationship;
import com.github.danimaniarqsoft.service.dto.RequirementUseCaseConceptsDTO;
import com.github.danimaniarqsoft.service.dto.UseCaseRelationshipDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UseCaseRelationship} and its DTO {@link UseCaseRelationshipDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseRelationshipMapper extends EntityMapper<UseCaseRelationshipDTO, UseCaseRelationship> {
    @Mapping(target = "requirementUseCaseConcepts", source = "requirementUseCaseConcepts", qualifiedByName = "requirementUseCaseConceptsId")
    UseCaseRelationshipDTO toDto(UseCaseRelationship s);

    @Named("requirementUseCaseConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementUseCaseConceptsDTO toDtoRequirementUseCaseConceptsId(RequirementUseCaseConcepts requirementUseCaseConcepts);
}
