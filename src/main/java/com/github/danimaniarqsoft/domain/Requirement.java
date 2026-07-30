package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.danimaniarqsoft.domain.enumeration.RequirementStatus;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Requirement.
 */
@Document(collection = "requirement")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Requirement implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("sent_id")
    private Integer sentId;

    @Field("text")
    private String text;

    @NotNull
    @Field("source")
    private String source;

    @NotNull
    @Field("project_id")
    private String projectId;

    @NotNull
    @Field("type")
    private String type;

    @NotNull
    @Field("spec_level")
    private String specLevel;

    @Field("class_diagram")
    private String classDiagram;

    @Field("use_case_diagram")
    private String useCaseDiagram;

    @Field("useCaseConcepts")
    private RequirementUseCaseConcepts useCaseConcepts;

    @Field("classConcepts")
    private RequirementClassConcepts classConcepts = new RequirementClassConcepts();

    @Field("status")
    private RequirementStatus status;

    @Field("created_at")
    private Instant createdAt;

    @Field("updated_at")
    private Instant updatedAt;

    @Field("project")
    @JsonIgnoreProperties(value = { "statistics", "createdBy", "annotatorses", "reviewerses" }, allowSetters = true)
    private Project project;

    @Field("annotatorses")
    private Set<User> annotatorses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Requirement id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSentId() {
        return this.sentId;
    }

    public Requirement sentId(Integer sentId) {
        this.setSentId(sentId);
        return this;
    }

    public void setSentId(Integer sentId) {
        this.sentId = sentId;
    }

    public String getText() {
        return this.text;
    }

    public Requirement text(String text) {
        this.setText(text);
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return this.source;
    }

    public Requirement source(String source) {
        this.setSource(source);
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public Requirement projectId(String projectId) {
        this.setProjectId(projectId);
        return this;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getType() {
        return this.type;
    }

    public Requirement type(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecLevel() {
        return this.specLevel;
    }

    public Requirement specLevel(String specLevel) {
        this.setSpecLevel(specLevel);
        return this;
    }

    public void setSpecLevel(String specLevel) {
        this.specLevel = specLevel;
    }

    public String getClassDiagram() {
        return this.classDiagram;
    }

    public Requirement classDiagram(String classDiagram) {
        this.setClassDiagram(classDiagram);
        return this;
    }

    public void setClassDiagram(String classDiagram) {
        this.classDiagram = classDiagram;
    }

    public String getUseCaseDiagram() {
        return this.useCaseDiagram;
    }

    public Requirement useCaseDiagram(String useCaseDiagram) {
        this.setUseCaseDiagram(useCaseDiagram);
        return this;
    }

    public void setUseCaseDiagram(String useCaseDiagram) {
        this.useCaseDiagram = useCaseDiagram;
    }

    public RequirementStatus getStatus() {
        return this.status;
    }

    public Requirement status(RequirementStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(RequirementStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Requirement createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Requirement updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public RequirementUseCaseConcepts getUseCaseConcepts() {
        return this.useCaseConcepts;
    }

    public void setUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.useCaseConcepts = requirementUseCaseConcepts;
    }

    public Requirement useCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.setUseCaseConcepts(requirementUseCaseConcepts);
        return this;
    }

    public RequirementClassConcepts getClassConcepts() {
        return this.classConcepts;
    }

    public void setClassConcepts(RequirementClassConcepts requirementClassConcepts) {
        this.classConcepts = requirementClassConcepts;
    }

    public Requirement classConcepts(RequirementClassConcepts requirementClassConcepts) {
        this.setClassConcepts(requirementClassConcepts);
        return this;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Requirement project(Project project) {
        this.setProject(project);
        return this;
    }

    public Set<User> getAnnotatorses() {
        return this.annotatorses;
    }

    public void setAnnotatorses(Set<User> users) {
        this.annotatorses = users;
    }

    public Requirement annotatorses(Set<User> users) {
        this.setAnnotatorses(users);
        return this;
    }

    public Requirement addAnnotators(User user) {
        this.annotatorses.add(user);
        return this;
    }

    public Requirement removeAnnotators(User user) {
        this.annotatorses.remove(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Requirement)) {
            return false;
        }
        return getId() != null && getId().equals(((Requirement) o).getId());
    }

    @Override
    public int hashCode() {
        // see
        // https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + getId() +
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
                "}";
    }
}
