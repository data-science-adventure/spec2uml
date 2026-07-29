package com.github.danimaniarqsoft.domain;

import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A ProjectStatistics.
 */
@Document(collection = "project_statistics")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProjectStatistics implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Min(value = 0)
    @Field("requirements")
    private Integer requirements;

    @Min(value = 0)
    @Field("completed")
    private Integer completed;

    @Min(value = 0)
    @Field("approved")
    private Integer approved;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public ProjectStatistics id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRequirements() {
        return this.requirements;
    }

    public ProjectStatistics requirements(Integer requirements) {
        this.setRequirements(requirements);
        return this;
    }

    public void setRequirements(Integer requirements) {
        this.requirements = requirements;
    }

    public Integer getCompleted() {
        return this.completed;
    }

    public ProjectStatistics completed(Integer completed) {
        this.setCompleted(completed);
        return this;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getApproved() {
        return this.approved;
    }

    public ProjectStatistics approved(Integer approved) {
        this.setApproved(approved);
        return this;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProjectStatistics)) {
            return false;
        }
        return getId() != null && getId().equals(((ProjectStatistics) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProjectStatistics{" +
            "id=" + getId() +
            ", requirements=" + getRequirements() +
            ", completed=" + getCompleted() +
            ", approved=" + getApproved() +
            "}";
    }
}
