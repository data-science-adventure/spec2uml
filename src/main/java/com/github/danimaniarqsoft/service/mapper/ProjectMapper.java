package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.ProjectStatistics;
import com.github.danimaniarqsoft.domain.User;
import com.github.danimaniarqsoft.service.dto.ProjectDTO;
import com.github.danimaniarqsoft.service.dto.ProjectStatisticsDTO;
import com.github.danimaniarqsoft.service.dto.UserDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Project} and its DTO {@link ProjectDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {
    @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "userId")
    @Mapping(target = "annotatorses", source = "annotatorses", qualifiedByName = "userIdSet")
    @Mapping(target = "reviewerses", source = "reviewerses", qualifiedByName = "userIdSet")
    ProjectDTO toDto(Project s);

    @Mapping(target = "removeAnnotators", ignore = true)
    @Mapping(target = "removeReviewers", ignore = true)
    Project toEntity(ProjectDTO projectDTO);

    @Named("projectStatisticsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProjectStatisticsDTO toDtoProjectStatisticsId(ProjectStatistics projectStatistics);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);

    @Named("userIdSet")
    default Set<UserDTO> toDtoUserIdSet(Set<User> user) {
        return user.stream().map(this::toDtoUserId).collect(Collectors.toSet());
    }
}
