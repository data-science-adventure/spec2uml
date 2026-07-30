package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.Requirement;
import com.github.danimaniarqsoft.domain.User;
import com.github.danimaniarqsoft.service.dto.ProjectDTO;
import com.github.danimaniarqsoft.service.dto.RequirementDTO;
import com.github.danimaniarqsoft.service.dto.UserDTO;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Requirement} and its DTO {@link RequirementDTO}.
 */
@Mapper(componentModel = "spring", uses = { RequirementUseCaseConceptsMapper.class, RequirementClassConceptsMapper.class })
public interface RequirementMapper extends EntityMapper<RequirementDTO, Requirement> {
    @Override
    @Mapping(target = "project", source = "project", qualifiedByName = "projectName")
    @Mapping(target = "annotatorses", source = "annotatorses", qualifiedByName = "userIdSet")
    RequirementDTO toDto(Requirement s);

    @Named("projectName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProjectDTO toDtoProjectName(Project project);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);

    @Named("userIdSet")
    default Set<UserDTO> toDtoUserIdSet(Set<User> user) {
        if (user == null) {
            return Collections.emptySet();
        }
        return user.stream().filter(Objects::nonNull).map(this::toDtoUserId).collect(Collectors.toSet());
    }
}
