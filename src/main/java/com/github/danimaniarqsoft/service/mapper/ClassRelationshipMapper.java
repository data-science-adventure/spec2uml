package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassRelationship;
import com.github.danimaniarqsoft.domain.RequirementClassConcepts;
import com.github.danimaniarqsoft.service.dto.ClassRelationshipDTO;
import com.github.danimaniarqsoft.service.dto.RequirementClassConceptsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ClassRelationship} and its DTO {@link ClassRelationshipDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassRelationshipMapper extends EntityMapper<ClassRelationshipDTO, ClassRelationship> {
    @Mapping(target = "requirementClassConcepts", source = "requirementClassConcepts", qualifiedByName = "requirementClassConceptsId")
    ClassRelationshipDTO toDto(ClassRelationship s);

    @Named("requirementClassConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementClassConceptsDTO toDtoRequirementClassConceptsId(RequirementClassConcepts requirementClassConcepts);
}
