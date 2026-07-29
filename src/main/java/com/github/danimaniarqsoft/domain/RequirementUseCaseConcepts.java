package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A RequirementUseCaseConcepts.
 */
@Document(collection = "requirement_use_case_concepts")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RequirementUseCaseConcepts implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("actors")
    @JsonIgnoreProperties(value = { "requirementUseCaseConcepts" }, allowSetters = true)
    private Set<UseCaseActor> actorses = new HashSet<>();

    @Field("useCases")
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
    private Set<UseCaseConcept> useCaseses = new HashSet<>();

    @Field("relationships")
    @JsonIgnoreProperties(value = { "requirementUseCaseConcepts" }, allowSetters = true)
    private Set<UseCaseRelationship> relationshipses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public RequirementUseCaseConcepts id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<UseCaseActor> getActorses() {
        return this.actorses;
    }

    public void setActorses(Set<UseCaseActor> useCaseActors) {
        if (this.actorses != null) {
            this.actorses.forEach(i -> i.setRequirementUseCaseConcepts(null));
        }
        if (useCaseActors != null) {
            useCaseActors.forEach(i -> i.setRequirementUseCaseConcepts(this));
        }
        this.actorses = useCaseActors;
    }

    public RequirementUseCaseConcepts actorses(Set<UseCaseActor> useCaseActors) {
        this.setActorses(useCaseActors);
        return this;
    }

    public RequirementUseCaseConcepts addActors(UseCaseActor useCaseActor) {
        this.actorses.add(useCaseActor);
        useCaseActor.setRequirementUseCaseConcepts(this);
        return this;
    }

    public RequirementUseCaseConcepts removeActors(UseCaseActor useCaseActor) {
        this.actorses.remove(useCaseActor);
        useCaseActor.setRequirementUseCaseConcepts(null);
        return this;
    }

    public Set<UseCaseConcept> getUseCaseses() {
        return this.useCaseses;
    }

    public void setUseCaseses(Set<UseCaseConcept> useCaseConcepts) {
        if (this.useCaseses != null) {
            this.useCaseses.forEach(i -> i.setRequirementUseCaseConcepts(null));
        }
        if (useCaseConcepts != null) {
            useCaseConcepts.forEach(i -> i.setRequirementUseCaseConcepts(this));
        }
        this.useCaseses = useCaseConcepts;
    }

    public RequirementUseCaseConcepts useCaseses(Set<UseCaseConcept> useCaseConcepts) {
        this.setUseCaseses(useCaseConcepts);
        return this;
    }

    public RequirementUseCaseConcepts addUseCases(UseCaseConcept useCaseConcept) {
        this.useCaseses.add(useCaseConcept);
        useCaseConcept.setRequirementUseCaseConcepts(this);
        return this;
    }

    public RequirementUseCaseConcepts removeUseCases(UseCaseConcept useCaseConcept) {
        this.useCaseses.remove(useCaseConcept);
        useCaseConcept.setRequirementUseCaseConcepts(null);
        return this;
    }

    public Set<UseCaseRelationship> getRelationshipses() {
        return this.relationshipses;
    }

    public void setRelationshipses(Set<UseCaseRelationship> useCaseRelationships) {
        if (this.relationshipses != null) {
            this.relationshipses.forEach(i -> i.setRequirementUseCaseConcepts(null));
        }
        if (useCaseRelationships != null) {
            useCaseRelationships.forEach(i -> i.setRequirementUseCaseConcepts(this));
        }
        this.relationshipses = useCaseRelationships;
    }

    public RequirementUseCaseConcepts relationshipses(Set<UseCaseRelationship> useCaseRelationships) {
        this.setRelationshipses(useCaseRelationships);
        return this;
    }

    public RequirementUseCaseConcepts addRelationships(UseCaseRelationship useCaseRelationship) {
        this.relationshipses.add(useCaseRelationship);
        useCaseRelationship.setRequirementUseCaseConcepts(this);
        return this;
    }

    public RequirementUseCaseConcepts removeRelationships(UseCaseRelationship useCaseRelationship) {
        this.relationshipses.remove(useCaseRelationship);
        useCaseRelationship.setRequirementUseCaseConcepts(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequirementUseCaseConcepts)) {
            return false;
        }
        return getId() != null && getId().equals(((RequirementUseCaseConcepts) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequirementUseCaseConcepts{" +
            "id=" + getId() +
            "}";
    }
}
