package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.ProjectStatistics;
import com.github.danimaniarqsoft.service.dto.ProjectStatisticsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProjectStatistics} and its DTO {@link ProjectStatisticsDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProjectStatisticsMapper extends EntityMapper<ProjectStatisticsDTO, ProjectStatistics> {}
