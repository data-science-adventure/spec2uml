package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A ClassAttribute.
 */
@Document(collection = "class_attribute")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassAttribute implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @NotNull
    @Field("type")
    private String type;

    @Field("visibility")
    private String visibility;

    @Field("classConcept")
    @JsonIgnoreProperties(value = { "attributeses", "operationses", "requirementClassConcepts" }, allowSetters = true)
    private ClassConcept classConcept;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public ClassAttribute id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public ClassAttribute name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public ClassAttribute type(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public ClassAttribute visibility(String visibility) {
        this.setVisibility(visibility);
        return this;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public ClassConcept getClassConcept() {
        return this.classConcept;
    }

    public void setClassConcept(ClassConcept classConcept) {
        this.classConcept = classConcept;
    }

    public ClassAttribute classConcept(ClassConcept classConcept) {
        this.setClassConcept(classConcept);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassAttribute)) {
            return false;
        }
        return getId() != null && getId().equals(((ClassAttribute) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassAttribute{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", visibility='" + getVisibility() + "'" +
            "}";
    }
}
