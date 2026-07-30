package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementClassConcepts;
import com.github.danimaniarqsoft.service.dto.RequirementClassConceptsDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link RequirementClassConcepts} and DTO {@link RequirementClassConceptsDTO}.
 */
@Mapper(componentModel = "spring", uses = { ClassConceptMapper.class, ClassRelationshipMapper.class })
public interface RequirementClassConceptsMapper extends EntityMapper<RequirementClassConceptsDTO, RequirementClassConcepts> {}
