package com.github.danimaniarqsoft.service.dto;

import com.github.danimaniarqsoft.domain.enumeration.Language;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.Project} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProjectDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Language language;

    private String umlVersion;

    @NotNull
    private Instant createdAt;

    private Instant updatedAt;

    private ProjectStatisticsDTO statistics;

    private UserDTO createdBy;

    private Set<UserDTO> annotatorses = new HashSet<>();

    private Set<UserDTO> reviewerses = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getUmlVersion() {
        return umlVersion;
    }

    public void setUmlVersion(String umlVersion) {
        this.umlVersion = umlVersion;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProjectStatisticsDTO getStatistics() {
        return statistics;
    }

    public void setStatistics(ProjectStatisticsDTO statistics) {
        this.statistics = statistics;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public Set<UserDTO> getAnnotatorses() {
        return annotatorses;
    }

    public void setAnnotatorses(Set<UserDTO> annotatorses) {
        this.annotatorses = annotatorses;
    }

    public Set<UserDTO> getReviewerses() {
        return reviewerses;
    }

    public void setReviewerses(Set<UserDTO> reviewerses) {
        this.reviewerses = reviewerses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProjectDTO)) {
            return false;
        }

        ProjectDTO projectDTO = (ProjectDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, projectDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProjectDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", language='" + getLanguage() + "'" +
            ", umlVersion='" + getUmlVersion() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", statistics=" + getStatistics() +
            ", createdBy=" + getCreatedBy() +
            ", annotatorses=" + getAnnotatorses() +
            ", reviewerses=" + getReviewerses() +
            "}";
    }
}
