package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.ClassRelationship} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassRelationshipDTO implements Serializable {

    private String id;

    @NotNull
    private String source;

    @NotNull
    private String target;

    @NotNull
    private String type;

    private String sourceMultiplicity;

    private String targetMultiplicity;

    private String label;

    private RequirementClassConceptsDTO requirementClassConcepts;

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

    public String getSourceMultiplicity() {
        return sourceMultiplicity;
    }

    public void setSourceMultiplicity(String sourceMultiplicity) {
        this.sourceMultiplicity = sourceMultiplicity;
    }

    public String getTargetMultiplicity() {
        return targetMultiplicity;
    }

    public void setTargetMultiplicity(String targetMultiplicity) {
        this.targetMultiplicity = targetMultiplicity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        if (!(o instanceof ClassRelationshipDTO)) {
            return false;
        }

        ClassRelationshipDTO classRelationshipDTO = (ClassRelationshipDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, classRelationshipDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassRelationshipDTO{" +
            "id='" + getId() + "'" +
            ", source='" + getSource() + "'" +
            ", target='" + getTarget() + "'" +
            ", type='" + getType() + "'" +
            ", sourceMultiplicity='" + getSourceMultiplicity() + "'" +
            ", targetMultiplicity='" + getTargetMultiplicity() + "'" +
            ", label='" + getLabel() + "'" +
            ", requirementClassConcepts=" + getRequirementClassConcepts() +
            "}";
    }
}
