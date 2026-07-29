package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.UseCaseActorRef;
import com.github.danimaniarqsoft.domain.UseCaseConcept;
import com.github.danimaniarqsoft.service.dto.UseCaseActorRefDTO;
import com.github.danimaniarqsoft.service.dto.UseCaseConceptDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link UseCaseActorRef} and its DTO {@link UseCaseActorRefDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseActorRefMapper extends EntityMapper<UseCaseActorRefDTO, UseCaseActorRef> {
    @Mapping(target = "primaryUseCaseConcept", source = "primaryUseCaseConcept", qualifiedByName = "useCaseConceptId")
    @Mapping(target = "secondaryUseCaseConcept", source = "secondaryUseCaseConcept", qualifiedByName = "useCaseConceptId")
    UseCaseActorRefDTO toDto(UseCaseActorRef s);

    @Named("useCaseConceptId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UseCaseConceptDTO toDtoUseCaseConceptId(UseCaseConcept useCaseConcept);
}
