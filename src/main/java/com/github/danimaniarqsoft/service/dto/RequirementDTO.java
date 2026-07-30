package com.github.danimaniarqsoft.service.dto;

import com.github.danimaniarqsoft.domain.enumeration.RequirementStatus;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.Requirement} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RequirementDTO implements Serializable {

    private String id;

    @NotNull
    private Integer sentId;

    private String text;

    @NotNull
    private String source;

    @NotNull
    private String projectId;

    @NotNull
    private String type;

    @NotNull
    private String specLevel;

    private String classDiagram;

    private String useCaseDiagram;

    private RequirementStatus status;

    private Instant createdAt;

    private Instant updatedAt;

    private RequirementUseCaseConceptsDTO useCaseConcepts;

    private RequirementClassConceptsDTO classConcepts;

    private ProjectDTO project;

    private Set<UserDTO> annotatorses = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSentId() {
        return sentId;
    }

    public void setSentId(Integer sentId) {
        this.sentId = sentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecLevel() {
        return specLevel;
    }

    public void setSpecLevel(String specLevel) {
        this.specLevel = specLevel;
    }

    public String getClassDiagram() {
        return classDiagram;
    }

    public void setClassDiagram(String classDiagram) {
        this.classDiagram = classDiagram;
    }

    public String getUseCaseDiagram() {
        return useCaseDiagram;
    }

    public void setUseCaseDiagram(String useCaseDiagram) {
        this.useCaseDiagram = useCaseDiagram;
    }

    public RequirementStatus getStatus() {
        return status;
    }

    public void setStatus(RequirementStatus status) {
        this.status = status;
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

    public RequirementUseCaseConceptsDTO getUseCaseConcepts() {
        return useCaseConcepts;
    }

    public void setUseCaseConcepts(RequirementUseCaseConceptsDTO useCaseConcepts) {
        this.useCaseConcepts = useCaseConcepts;
    }

    public RequirementClassConceptsDTO getClassConcepts() {
        return classConcepts;
    }

    public void setClassConcepts(RequirementClassConceptsDTO classConcepts) {
        this.classConcepts = classConcepts;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public Set<UserDTO> getAnnotatorses() {
        return annotatorses;
    }

    public void setAnnotatorses(Set<UserDTO> annotatorses) {
        this.annotatorses = annotatorses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequirementDTO)) {
            return false;
        }

        RequirementDTO requirementDTO = (RequirementDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, requirementDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequirementDTO{" +
            "id='" + getId() + "'" +
            ", sentId=" + getSentId() +
            ", text='" + getText() + "'" +
            ", source='" + getSource() + "'" +
            ", projectId='" + getProjectId() + "'" +
            ", type='" + getType() + "'" +
            ", specLevel='" + getSpecLevel() + "'" +
            ", classDiagram='" + getClassDiagram() + "'" +
            ", useCaseDiagram='" + getUseCaseDiagram() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", useCaseConcepts=" + getUseCaseConcepts() +
            ", classConcepts=" + getClassConcepts() +
            ", project=" + getProject() +
            ", annotatorses=" + getAnnotatorses() +
            "}";
    }
}
