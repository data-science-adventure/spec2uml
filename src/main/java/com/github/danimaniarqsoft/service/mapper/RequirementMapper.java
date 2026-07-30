package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.Requirement;
import com.github.danimaniarqsoft.domain.UserRef;
import com.github.danimaniarqsoft.service.dto.ProjectDTO;
import com.github.danimaniarqsoft.service.dto.RequirementDTO;
import com.github.danimaniarqsoft.service.dto.UserRefDTO;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Requirement} and its DTO {@link RequirementDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = { RequirementUseCaseConceptsMapper.class, RequirementClassConceptsMapper.class, UserRefMapper.class }
)
public interface RequirementMapper extends EntityMapper<RequirementDTO, Requirement> {
    @Override
    @Mapping(target = "project", source = "project", qualifiedByName = "projectName")
    @Mapping(target = "annotatorses", source = "annotatorses", qualifiedByName = "userRefIdSet")
    RequirementDTO toDto(Requirement s);

    @Named("projectName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProjectDTO toDtoProjectName(Project project);

    @Named("userRefId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    UserRefDTO toDtoUserRefId(UserRef userRef);

    @Named("userRefIdSet")
    default Set<UserRefDTO> toDtoUserRefIdSet(Set<UserRef> userRefs) {
        if (userRefs == null) {
            return Collections.emptySet();
        }
        return userRefs.stream().filter(Objects::nonNull).map(this::toDtoUserRefId).collect(Collectors.toSet());
    }
}
