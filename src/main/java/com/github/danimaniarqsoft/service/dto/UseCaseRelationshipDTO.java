package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.UseCaseRelationship} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseRelationshipDTO implements Serializable {

    private String id;

    @NotNull
    private String source;

    @NotNull
    private String target;

    @NotNull
    private String type;

    private String label;

    private RequirementUseCaseConceptsDTO requirementUseCaseConcepts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public RequirementUseCaseConceptsDTO getRequirementUseCaseConcepts() {
        return requirementUseCaseConcepts;
    }

    public void setRequirementUseCaseConcepts(RequirementUseCaseConceptsDTO requirementUseCaseConcepts) {
        this.requirementUseCaseConcepts = requirementUseCaseConcepts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseRelationshipDTO)) {
            return false;
        }

        UseCaseRelationshipDTO useCaseRelationshipDTO = (UseCaseRelationshipDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, useCaseRelationshipDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseRelationshipDTO{" +
            "id='" + getId() + "'" +
            ", source='" + getSource() + "'" +
            ", target='" + getTarget() + "'" +
            ", type='" + getType() + "'" +
            ", label='" + getLabel() + "'" +
            ", requirementUseCaseConcepts=" + getRequirementUseCaseConcepts() +
            "}";
    }
}
