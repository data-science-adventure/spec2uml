package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts;
import com.github.danimaniarqsoft.domain.UseCaseActor;
import com.github.danimaniarqsoft.service.dto.RequirementUseCaseConceptsDTO;
import com.github.danimaniarqsoft.service.dto.UseCaseActorDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UseCaseActor} and its DTO {@link UseCaseActorDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseActorMapper extends EntityMapper<UseCaseActorDTO, UseCaseActor> {
    @Mapping(target = "requirementUseCaseConcepts", source = "requirementUseCaseConcepts", qualifiedByName = "requirementUseCaseConceptsId")
    UseCaseActorDTO toDto(UseCaseActor s);

    @Named("requirementUseCaseConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementUseCaseConceptsDTO toDtoRequirementUseCaseConceptsId(RequirementUseCaseConcepts requirementUseCaseConcepts);
}
