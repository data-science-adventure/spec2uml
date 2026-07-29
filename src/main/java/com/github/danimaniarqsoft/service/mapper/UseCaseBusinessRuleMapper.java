package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.UseCaseBusinessRule;
import com.github.danimaniarqsoft.domain.UseCaseConcept;
import com.github.danimaniarqsoft.service.dto.UseCaseBusinessRuleDTO;
import com.github.danimaniarqsoft.service.dto.UseCaseConceptDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UseCaseBusinessRule} and its DTO {@link UseCaseBusinessRuleDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseBusinessRuleMapper extends EntityMapper<UseCaseBusinessRuleDTO, UseCaseBusinessRule> {
    @Mapping(target = "useCaseConcept", source = "useCaseConcept", qualifiedByName = "useCaseConceptId")
    UseCaseBusinessRuleDTO toDto(UseCaseBusinessRule s);

    @Named("useCaseConceptId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UseCaseConceptDTO toDtoUseCaseConceptId(UseCaseConcept useCaseConcept);
}
