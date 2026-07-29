package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A UseCaseRelationship.
 */
@Document(collection = "use_case_relationship")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseRelationship implements Serializable {

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

    @Field("label")
    private String label;

    @Field("requirementUseCaseConcepts")
    @JsonIgnoreProperties(value = { "actorses", "useCaseses", "relationshipses" }, allowSetters = true)
    private RequirementUseCaseConcepts requirementUseCaseConcepts;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UseCaseRelationship id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public UseCaseRelationship source(String source) {
        this.setSource(source);
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return this.target;
    }

    public UseCaseRelationship target(String target) {
        this.setTarget(target);
        return this;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return this.type;
    }

    public UseCaseRelationship type(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return this.label;
    }

    public UseCaseRelationship label(String label) {
        this.setLabel(label);
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public RequirementUseCaseConcepts getRequirementUseCaseConcepts() {
        return this.requirementUseCaseConcepts;
    }

    public void setRequirementUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.requirementUseCaseConcepts = requirementUseCaseConcepts;
    }

    public UseCaseRelationship requirementUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.setRequirementUseCaseConcepts(requirementUseCaseConcepts);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseRelationship)) {
            return false;
        }
        return getId() != null && getId().equals(((UseCaseRelationship) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseRelationship{" +
            "id=" + getId() +
            ", source='" + getSource() + "'" +
            ", target='" + getTarget() + "'" +
            ", type='" + getType() + "'" +
            ", label='" + getLabel() + "'" +
            "}";
    }
}
