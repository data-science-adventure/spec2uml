package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.RequirementClassConcepts} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RequirementClassConceptsDTO implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequirementClassConceptsDTO)) {
            return false;
        }

        RequirementClassConceptsDTO requirementClassConceptsDTO = (RequirementClassConceptsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, requirementClassConceptsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequirementClassConceptsDTO{" +
            "id='" + getId() + "'" +
            "}";
    }
}
