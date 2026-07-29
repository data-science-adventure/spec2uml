package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.Requirement;
import com.github.danimaniarqsoft.domain.RequirementClassConcepts;
import com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts;
import com.github.danimaniarqsoft.domain.User;
import com.github.danimaniarqsoft.service.dto.ProjectDTO;
import com.github.danimaniarqsoft.service.dto.RequirementClassConceptsDTO;
import com.github.danimaniarqsoft.service.dto.RequirementDTO;
import com.github.danimaniarqsoft.service.dto.RequirementUseCaseConceptsDTO;
import com.github.danimaniarqsoft.service.dto.UserDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Requirement} and its DTO {@link RequirementDTO}.
 */
@Mapper(componentModel = "spring")
public interface RequirementMapper extends EntityMapper<RequirementDTO, Requirement> {
    @Mapping(target = "useCaseConcepts", source = "useCaseConcepts", qualifiedByName = "requirementUseCaseConceptsId")
    @Mapping(target = "classConcepts", source = "classConcepts", qualifiedByName = "requirementClassConceptsId")
    @Mapping(target = "project", source = "project", qualifiedByName = "projectName")
    @Mapping(target = "annotatorses", source = "annotatorses", qualifiedByName = "userIdSet")
    RequirementDTO toDto(Requirement s);

    @Mapping(target = "removeAnnotators", ignore = true)
    Requirement toEntity(RequirementDTO requirementDTO);

    @Named("requirementUseCaseConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementUseCaseConceptsDTO toDtoRequirementUseCaseConceptsId(RequirementUseCaseConcepts requirementUseCaseConcepts);

    @Named("requirementClassConceptsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RequirementClassConceptsDTO toDtoRequirementClassConceptsId(RequirementClassConcepts requirementClassConcepts);

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
        return user.stream().map(this::toDtoUserId).collect(Collectors.toSet());
    }
}
