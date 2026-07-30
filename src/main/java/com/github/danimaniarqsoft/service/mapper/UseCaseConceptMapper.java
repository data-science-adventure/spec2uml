package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.UseCaseConcept;
import com.github.danimaniarqsoft.service.dto.UseCaseConceptDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link UseCaseConcept} and DTO {@link UseCaseConceptDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseConceptMapper extends EntityMapper<UseCaseConceptDTO, UseCaseConcept> {}
