package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassConcept;
import com.github.danimaniarqsoft.domain.RequirementClassConcepts;
import com.github.danimaniarqsoft.service.dto.ClassConceptDTO;
import com.github.danimaniarqsoft.service.dto.RequirementClassConceptsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ClassConcept} and its DTO {@link ClassConceptDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassConceptMapper extends EntityMapper<ClassConceptDTO, ClassConcept> {
    @Mapping(target = "requirementClassConcepts", source = "requirementClassConcepts", qualifiedByName = "requirementClassConceptsId")
    ClassConceptDTO toDto(ClassConcept s);

    @Named("requirementClassConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementClassConceptsDTO toDtoRequirementClassConceptsId(RequirementClassConcepts requirementClassConcepts);
}
