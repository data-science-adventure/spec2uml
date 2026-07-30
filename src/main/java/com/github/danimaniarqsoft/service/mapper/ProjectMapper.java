package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.UserRef;
import com.github.danimaniarqsoft.service.dto.ProjectDTO;
import com.github.danimaniarqsoft.service.dto.UserRefDTO;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Project} and its DTO {@link ProjectDTO}.
 * Uses {@link UserRefMapper} to handle lightweight user reference mappings.
 */
@Mapper(componentModel = "spring", uses = { UserRefMapper.class })
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {
    @Override
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "userRefId")
    @Mapping(target = "annotatorses", source = "annotatorses", qualifiedByName = "userRefIdSet")
    @Mapping(target = "reviewerses", source = "reviewerses", qualifiedByName = "userRefIdSet")
    ProjectDTO toDto(Project s);

    @Override
    @BeanMapping(builder = @Builder(disableBuilder = true))
    Project toEntity(ProjectDTO projectDTO);

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
