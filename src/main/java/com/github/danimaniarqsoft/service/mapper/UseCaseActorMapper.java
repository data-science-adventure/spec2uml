package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.UseCaseActor;
import com.github.danimaniarqsoft.service.dto.UseCaseActorDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for entity {@link UseCaseActor} and DTO {@link UseCaseActorDTO}.
 */
@Mapper(componentModel = "spring")
public interface UseCaseActorMapper extends EntityMapper<UseCaseActorDTO, UseCaseActor> {}
