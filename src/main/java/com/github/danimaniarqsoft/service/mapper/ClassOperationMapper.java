package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassConcept;
import com.github.danimaniarqsoft.domain.ClassOperation;
import com.github.danimaniarqsoft.service.dto.ClassConceptDTO;
import com.github.danimaniarqsoft.service.dto.ClassOperationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ClassOperation} and its DTO {@link ClassOperationDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassOperationMapper extends EntityMapper<ClassOperationDTO, ClassOperation> {
    @Mapping(target = "classConcept", source = "classConcept", qualifiedByName = "classConceptId")
    ClassOperationDTO toDto(ClassOperation s);

    @Named("classConceptId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClassConceptDTO toDtoClassConceptId(ClassConcept classConcept);
}
