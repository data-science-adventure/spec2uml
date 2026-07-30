package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassConcept;
import com.github.danimaniarqsoft.service.dto.ClassConceptDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link ClassConcept} and DTO {@link ClassConceptDTO}.
 */
@Mapper(componentModel = "spring", uses = { ClassAttributeMapper.class, ClassOperationMapper.class })
public interface ClassConceptMapper extends EntityMapper<ClassConceptDTO, ClassConcept> {}
