package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ClassAttribute;
import com.github.danimaniarqsoft.domain.ClassConcept;
import com.github.danimaniarqsoft.service.dto.ClassAttributeDTO;
import com.github.danimaniarqsoft.service.dto.ClassConceptDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ClassAttribute} and its DTO {@link ClassAttributeDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClassAttributeMapper extends EntityMapper<ClassAttributeDTO, ClassAttribute> {
    @Mapping(target = "classConcept", source = "classConcept", qualifiedByName = "classConceptId")
    ClassAttributeDTO toDto(ClassAttribute s);

    @Named("classConceptId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClassConceptDTO toDtoClassConceptId(ClassConcept classConcept);
}
