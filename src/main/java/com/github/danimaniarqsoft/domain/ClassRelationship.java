package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A ClassRelationship.
 */
@Document(collection = "class_relationship")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassRelationship implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("source")
    private String source;

    @NotNull
    @Field("target")
    private String target;

    @NotNull
    @Field("type")
    private String type;

    @Field("source_multiplicity")
    private String sourceMultiplicity;

    @Field("target_multiplicity")
    private String targetMultiplicity;

    @Field("label")
    private String label;

    @Field("requirementClassConcepts")
    @JsonIgnoreProperties(value = { "classeses", "relationshipses" }, allowSetters = true)
    private RequirementClassConcepts requirementClassConcepts;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public ClassRelationship id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public ClassRelationship source(String source) {
        this.setSource(source);
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return this.target;
    }

    public ClassRelationship target(String target) {
        this.setTarget(target);
        return this;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return this.type;
    }

    public ClassRelationship type(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceMultiplicity() {
        return this.sourceMultiplicity;
    }

    public ClassRelationship sourceMultiplicity(String sourceMultiplicity) {
        this.setSourceMultiplicity(sourceMultiplicity);
        return this;
    }

    public void setSourceMultiplicity(String sourceMultiplicity) {
        this.sourceMultiplicity = sourceMultiplicity;
    }

    public String getTargetMultiplicity() {
        return this.targetMultiplicity;
    }

    public ClassRelationship targetMultiplicity(String targetMultiplicity) {
        this.setTargetMultiplicity(targetMultiplicity);
        return this;
    }

    public void setTargetMultiplicity(String targetMultiplicity) {
        this.targetMultiplicity = targetMultiplicity;
    }

    public String getLabel() {
        return this.label;
    }

    public ClassRelationship label(String label) {
        this.setLabel(label);
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public RequirementClassConcepts getRequirementClassConcepts() {
        return this.requirementClassConcepts;
    }

    public void setRequirementClassConcepts(RequirementClassConcepts requirementClassConcepts) {
        this.requirementClassConcepts = requirementClassConcepts;
    }

    public ClassRelationship requirementClassConcepts(RequirementClassConcepts requirementClassConcepts) {
        this.setRequirementClassConcepts(requirementClassConcepts);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassRelationship)) {
            return false;
        }
        return getId() != null && getId().equals(((ClassRelationship) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassRelationship{" +
            "id=" + getId() +
            ", source='" + getSource() + "'" +
            ", target='" + getTarget() + "'" +
            ", type='" + getType() + "'" +
            ", sourceMultiplicity='" + getSourceMultiplicity() + "'" +
            ", targetMultiplicity='" + getTargetMultiplicity() + "'" +
            ", label='" + getLabel() + "'" +
            "}";
    }
}
