package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A UseCaseActorRef.
 */
@Document(collection = "use_case_actor_ref")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseActorRef implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("actor_name")
    private String actorName;

    @Field("primaryUseCaseConcept")
    @JsonIgnoreProperties(
        value = {
            "primaryActorses",
            "secondaryActorses",
            "preconditionses",
            "postconditionses",
            "businessRuleses",
            "requirementUseCaseConcepts",
        },
        allowSetters = true
    )
    private UseCaseConcept primaryUseCaseConcept;

    @Field("secondaryUseCaseConcept")
    @JsonIgnoreProperties(
        value = {
            "primaryActorses",
            "secondaryActorses",
            "preconditionses",
            "postconditionses",
            "businessRuleses",
            "requirementUseCaseConcepts",
        },
        allowSetters = true
    )
    private UseCaseConcept secondaryUseCaseConcept;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UseCaseActorRef id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActorName() {
        return this.actorName;
    }

    public UseCaseActorRef actorName(String actorName) {
        this.setActorName(actorName);
        return this;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public UseCaseConcept getPrimaryUseCaseConcept() {
        return this.primaryUseCaseConcept;
    }

    public void setPrimaryUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.primaryUseCaseConcept = useCaseConcept;
    }

    public UseCaseActorRef primaryUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.setPrimaryUseCaseConcept(useCaseConcept);
        return this;
    }

    public UseCaseConcept getSecondaryUseCaseConcept() {
        return this.secondaryUseCaseConcept;
    }

    public void setSecondaryUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.secondaryUseCaseConcept = useCaseConcept;
    }

    public UseCaseActorRef secondaryUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.setSecondaryUseCaseConcept(useCaseConcept);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseActorRef)) {
            return false;
        }
        return getId() != null && getId().equals(((UseCaseActorRef) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseActorRef{" +
            "id=" + getId() +
            ", actorName='" + getActorName() + "'" +
            "}";
    }
}
