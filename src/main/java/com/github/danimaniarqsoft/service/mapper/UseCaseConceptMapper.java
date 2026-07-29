package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts;
import com.github.danimaniarqsoft.domain.UseCaseConcept;
import com.github.danimaniarqsoft.service.dto.RequirementUseCaseConceptsDTO;
import com.github.danimaniarqsoft.service.dto.UseCaseConceptDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UseCaseConcept} and its DTO {@link UseCaseConceptDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseConceptMapper extends EntityMapper<UseCaseConceptDTO, UseCaseConcept> {
    @Mapping(target = "requirementUseCaseConcepts", source = "requirementUseCaseConcepts", qualifiedByName = "requirementUseCaseConceptsId")
    UseCaseConceptDTO toDto(UseCaseConcept s);

    @Named("requirementUseCaseConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementUseCaseConceptsDTO toDtoRequirementUseCaseConceptsId(RequirementUseCaseConcepts requirementUseCaseConcepts);
}
