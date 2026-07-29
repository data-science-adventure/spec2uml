package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.RequirementClassConcepts;
import com.github.danimaniarqsoft.service.dto.RequirementClassConceptsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link RequirementClassConcepts} and its DTO {@link RequirementClassConceptsDTO}.
 */
@Mapper(componentModel = "spring")
public interface RequirementClassConceptsMapper extends EntityMapper<RequirementClassConceptsDTO, RequirementClassConcepts> {}
