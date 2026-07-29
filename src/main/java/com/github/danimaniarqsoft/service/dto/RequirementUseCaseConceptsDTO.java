package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.RequirementUseCaseConcepts} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RequirementUseCaseConceptsDTO implements Serializable {

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
        if (!(o instanceof RequirementUseCaseConceptsDTO)) {
            return false;
        }

        RequirementUseCaseConceptsDTO requirementUseCaseConceptsDTO = (RequirementUseCaseConceptsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, requirementUseCaseConceptsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequirementUseCaseConceptsDTO{" +
            "id='" + getId() + "'" +
            "}";
    }
}
