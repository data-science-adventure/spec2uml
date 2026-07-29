package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.ClassConcept} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassConceptDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    private String stereotype;

    private RequirementClassConceptsDTO requirementClassConcepts;

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

    public String getStereotype() {
        return stereotype;
    }

    public void setStereotype(String stereotype) {
        this.stereotype = stereotype;
    }

    public RequirementClassConceptsDTO getRequirementClassConcepts() {
        return requirementClassConcepts;
    }

    public void setRequirementClassConcepts(RequirementClassConceptsDTO requirementClassConcepts) {
        this.requirementClassConcepts = requirementClassConcepts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassConceptDTO)) {
            return false;
        }

        ClassConceptDTO classConceptDTO = (ClassConceptDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, classConceptDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassConceptDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", stereotype='" + getStereotype() + "'" +
            ", requirementClassConcepts=" + getRequirementClassConcepts() +
            "}";
    }
}
