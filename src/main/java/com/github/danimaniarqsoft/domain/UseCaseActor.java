package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A UseCaseActor.
 */
@Document(collection = "use_case_actor")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseActor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("requirementUseCaseConcepts")
    @JsonIgnoreProperties(value = { "actorses", "useCaseses", "relationshipses" }, allowSetters = true)
    private RequirementUseCaseConcepts requirementUseCaseConcepts;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UseCaseActor id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public UseCaseActor name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public UseCaseActor description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RequirementUseCaseConcepts getRequirementUseCaseConcepts() {
        return this.requirementUseCaseConcepts;
    }

    public void setRequirementUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.requirementUseCaseConcepts = requirementUseCaseConcepts;
    }

    public UseCaseActor requirementUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.setRequirementUseCaseConcepts(requirementUseCaseConcepts);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseActor)) {
            return false;
        }
        return getId() != null && getId().equals(((UseCaseActor) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseActor{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
