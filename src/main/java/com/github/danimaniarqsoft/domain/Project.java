package com.github.danimaniarqsoft.domain;

import com.github.danimaniarqsoft.domain.enumeration.Language;
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
 * A Project.
 */
@Document(collection = "project")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Project implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @NotNull
    @Field("language")
    private Language language;

    @Field("uml_version")
    private String umlVersion;

    @NotNull
    @Field("created_at")
    private Instant createdAt;

    @Field("updated_at")
    private Instant updatedAt;

    @Field("statistics")
    private ProjectStatistics statistics;

    @Field("createdBy")
    private User createdBy;

    @Field("annotatorses")
    private Set<User> annotatorses = new HashSet<>();

    @Field("reviewerses")
    private Set<User> reviewerses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Project id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Project name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public Project description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return this.language;
    }

    public Project language(Language language) {
        this.setLanguage(language);
        return this;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getUmlVersion() {
        return this.umlVersion;
    }

    public Project umlVersion(String umlVersion) {
        this.setUmlVersion(umlVersion);
        return this;
    }

    public void setUmlVersion(String umlVersion) {
        this.umlVersion = umlVersion;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Project createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Project updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProjectStatistics getStatistics() {
        return this.statistics;
    }

    public void setStatistics(ProjectStatistics projectStatistics) {
        this.statistics = projectStatistics;
    }

    public Project statistics(ProjectStatistics projectStatistics) {
        this.setStatistics(projectStatistics);
        return this;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User user) {
        this.createdBy = user;
    }

    public Project createdBy(User user) {
        this.setCreatedBy(user);
        return this;
    }

    public Set<User> getAnnotatorses() {
        return this.annotatorses;
    }

    public void setAnnotatorses(Set<User> users) {
        this.annotatorses = users;
    }

    public Project annotatorses(Set<User> users) {
        this.setAnnotatorses(users);
        return this;
    }

    public Project addAnnotators(User user) {
        this.annotatorses.add(user);
        return this;
    }

    public Project removeAnnotators(User user) {
        this.annotatorses.remove(user);
        return this;
    }

    public Set<User> getReviewerses() {
        return this.reviewerses;
    }

    public void setReviewerses(Set<User> users) {
        this.reviewerses = users;
    }

    public Project reviewerses(Set<User> users) {
        this.setReviewerses(users);
        return this;
    }

    public Project addReviewers(User user) {
        this.reviewerses.add(user);
        return this;
    }

    public Project removeReviewers(User user) {
        this.reviewerses.remove(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Project)) {
            return false;
        }
        return getId() != null && getId().equals(((Project) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", language='" + getLanguage() + "'" +
            ", umlVersion='" + getUmlVersion() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
