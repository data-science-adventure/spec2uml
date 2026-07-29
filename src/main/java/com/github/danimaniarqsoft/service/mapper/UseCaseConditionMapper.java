package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.UseCaseConcept;
import com.github.danimaniarqsoft.domain.UseCaseCondition;
import com.github.danimaniarqsoft.service.dto.UseCaseConceptDTO;
import com.github.danimaniarqsoft.service.dto.UseCaseConditionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UseCaseCondition} and its DTO {@link UseCaseConditionDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseConditionMapper extends EntityMapper<UseCaseConditionDTO, UseCaseCondition> {
    @Mapping(target = "preconditionUseCaseConcept", source = "preconditionUseCaseConcept", qualifiedByName = "useCaseConceptId")
    @Mapping(target = "postconditionUseCaseConcept", source = "postconditionUseCaseConcept", qualifiedByName = "useCaseConceptId")
    UseCaseConditionDTO toDto(UseCaseCondition s);

    @Named("useCaseConceptId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UseCaseConceptDTO toDtoUseCaseConceptId(UseCaseConcept useCaseConcept);
}
