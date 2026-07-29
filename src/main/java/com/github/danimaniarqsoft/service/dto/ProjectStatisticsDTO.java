package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.ProjectStatistics} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProjectStatisticsDTO implements Serializable {

    private String id;

    @Min(value = 0)
    private Integer requirements;

    @Min(value = 0)
    private Integer completed;

    @Min(value = 0)
    private Integer approved;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRequirements() {
        return requirements;
    }

    public void setRequirements(Integer requirements) {
        this.requirements = requirements;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProjectStatisticsDTO)) {
            return false;
        }

        ProjectStatisticsDTO projectStatisticsDTO = (ProjectStatisticsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, projectStatisticsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProjectStatisticsDTO{" +
            "id='" + getId() + "'" +
            ", requirements=" + getRequirements() +
            ", completed=" + getCompleted() +
            ", approved=" + getApproved() +
            "}";
    }
}
