package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.ClassAttribute} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassAttributeDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    private String visibility;

    private ClassConceptDTO classConcept;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public ClassConceptDTO getClassConcept() {
        return classConcept;
    }

    public void setClassConcept(ClassConceptDTO classConcept) {
        this.classConcept = classConcept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassAttributeDTO)) {
            return false;
        }

        ClassAttributeDTO classAttributeDTO = (ClassAttributeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, classAttributeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassAttributeDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", visibility='" + getVisibility() + "'" +
            ", classConcept=" + getClassConcept() +
            "}";
    }
}
