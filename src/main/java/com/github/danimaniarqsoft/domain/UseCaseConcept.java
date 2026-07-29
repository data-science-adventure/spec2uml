package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A UseCaseConcept.
 */
@Document(collection = "use_case_concept")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseConcept implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("trigger")
    private String trigger;

    @Field("system_boundary")
    private String systemBoundary;

    @Field("primaryActors")
    @JsonIgnoreProperties(value = { "primaryUseCaseConcept", "secondaryUseCaseConcept" }, allowSetters = true)
    private Set<UseCaseActorRef> primaryActorses = new HashSet<>();

    @Field("secondaryActors")
    @JsonIgnoreProperties(value = { "primaryUseCaseConcept", "secondaryUseCaseConcept" }, allowSetters = true)
    private Set<UseCaseActorRef> secondaryActorses = new HashSet<>();

    @Field("preconditions")
    @JsonIgnoreProperties(value = { "preconditionUseCaseConcept", "postconditionUseCaseConcept" }, allowSetters = true)
    private Set<UseCaseCondition> preconditionses = new HashSet<>();

    @Field("postconditions")
    @JsonIgnoreProperties(value = { "preconditionUseCaseConcept", "postconditionUseCaseConcept" }, allowSetters = true)
    private Set<UseCaseCondition> postconditionses = new HashSet<>();

    @Field("businessRules")
    @JsonIgnoreProperties(value = { "useCaseConcept" }, allowSetters = true)
    private Set<UseCaseBusinessRule> businessRuleses = new HashSet<>();

    @Field("requirementUseCaseConcepts")
    @JsonIgnoreProperties(value = { "actorses", "useCaseses", "relationshipses" }, allowSetters = true)
    private RequirementUseCaseConcepts requirementUseCaseConcepts;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UseCaseConcept id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public UseCaseConcept name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public UseCaseConcept description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public UseCaseConcept trigger(String trigger) {
        this.setTrigger(trigger);
        return this;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getSystemBoundary() {
        return this.systemBoundary;
    }

    public UseCaseConcept systemBoundary(String systemBoundary) {
        this.setSystemBoundary(systemBoundary);
        return this;
    }

    public void setSystemBoundary(String systemBoundary) {
        this.systemBoundary = systemBoundary;
    }

    public Set<UseCaseActorRef> getPrimaryActorses() {
        return this.primaryActorses;
    }

    public void setPrimaryActorses(Set<UseCaseActorRef> useCaseActorRefs) {
        if (this.primaryActorses != null) {
            this.primaryActorses.forEach(i -> i.setPrimaryUseCaseConcept(null));
        }
        if (useCaseActorRefs != null) {
            useCaseActorRefs.forEach(i -> i.setPrimaryUseCaseConcept(this));
        }
        this.primaryActorses = useCaseActorRefs;
    }

    public UseCaseConcept primaryActorses(Set<UseCaseActorRef> useCaseActorRefs) {
        this.setPrimaryActorses(useCaseActorRefs);
        return this;
    }

    public UseCaseConcept addPrimaryActors(UseCaseActorRef useCaseActorRef) {
        this.primaryActorses.add(useCaseActorRef);
        useCaseActorRef.setPrimaryUseCaseConcept(this);
        return this;
    }

    public UseCaseConcept removePrimaryActors(UseCaseActorRef useCaseActorRef) {
        this.primaryActorses.remove(useCaseActorRef);
        useCaseActorRef.setPrimaryUseCaseConcept(null);
        return this;
    }

    public Set<UseCaseActorRef> getSecondaryActorses() {
        return this.secondaryActorses;
    }

    public void setSecondaryActorses(Set<UseCaseActorRef> useCaseActorRefs) {
        if (this.secondaryActorses != null) {
            this.secondaryActorses.forEach(i -> i.setSecondaryUseCaseConcept(null));
        }
        if (useCaseActorRefs != null) {
            useCaseActorRefs.forEach(i -> i.setSecondaryUseCaseConcept(this));
        }
        this.secondaryActorses = useCaseActorRefs;
    }

    public UseCaseConcept secondaryActorses(Set<UseCaseActorRef> useCaseActorRefs) {
        this.setSecondaryActorses(useCaseActorRefs);
        return this;
    }

    public UseCaseConcept addSecondaryActors(UseCaseActorRef useCaseActorRef) {
        this.secondaryActorses.add(useCaseActorRef);
        useCaseActorRef.setSecondaryUseCaseConcept(this);
        return this;
    }

    public UseCaseConcept removeSecondaryActors(UseCaseActorRef useCaseActorRef) {
        this.secondaryActorses.remove(useCaseActorRef);
        useCaseActorRef.setSecondaryUseCaseConcept(null);
        return this;
    }

    public Set<UseCaseCondition> getPreconditionses() {
        return this.preconditionses;
    }

    public void setPreconditionses(Set<UseCaseCondition> useCaseConditions) {
        if (this.preconditionses != null) {
            this.preconditionses.forEach(i -> i.setPreconditionUseCaseConcept(null));
        }
        if (useCaseConditions != null) {
            useCaseConditions.forEach(i -> i.setPreconditionUseCaseConcept(this));
        }
        this.preconditionses = useCaseConditions;
    }

    public UseCaseConcept preconditionses(Set<UseCaseCondition> useCaseConditions) {
        this.setPreconditionses(useCaseConditions);
        return this;
    }

    public UseCaseConcept addPreconditions(UseCaseCondition useCaseCondition) {
        this.preconditionses.add(useCaseCondition);
        useCaseCondition.setPreconditionUseCaseConcept(this);
        return this;
    }

    public UseCaseConcept removePreconditions(UseCaseCondition useCaseCondition) {
        this.preconditionses.remove(useCaseCondition);
        useCaseCondition.setPreconditionUseCaseConcept(null);
        return this;
    }

    public Set<UseCaseCondition> getPostconditionses() {
        return this.postconditionses;
    }

    public void setPostconditionses(Set<UseCaseCondition> useCaseConditions) {
        if (this.postconditionses != null) {
            this.postconditionses.forEach(i -> i.setPostconditionUseCaseConcept(null));
        }
        if (useCaseConditions != null) {
            useCaseConditions.forEach(i -> i.setPostconditionUseCaseConcept(this));
        }
        this.postconditionses = useCaseConditions;
    }

    public UseCaseConcept postconditionses(Set<UseCaseCondition> useCaseConditions) {
        this.setPostconditionses(useCaseConditions);
        return this;
    }

    public UseCaseConcept addPostconditions(UseCaseCondition useCaseCondition) {
        this.postconditionses.add(useCaseCondition);
        useCaseCondition.setPostconditionUseCaseConcept(this);
        return this;
    }

    public UseCaseConcept removePostconditions(UseCaseCondition useCaseCondition) {
        this.postconditionses.remove(useCaseCondition);
        useCaseCondition.setPostconditionUseCaseConcept(null);
        return this;
    }

    public Set<UseCaseBusinessRule> getBusinessRuleses() {
        return this.businessRuleses;
    }

    public void setBusinessRuleses(Set<UseCaseBusinessRule> useCaseBusinessRules) {
        if (this.businessRuleses != null) {
            this.businessRuleses.forEach(i -> i.setUseCaseConcept(null));
        }
        if (useCaseBusinessRules != null) {
            useCaseBusinessRules.forEach(i -> i.setUseCaseConcept(this));
        }
        this.businessRuleses = useCaseBusinessRules;
    }

    public UseCaseConcept businessRuleses(Set<UseCaseBusinessRule> useCaseBusinessRules) {
        this.setBusinessRuleses(useCaseBusinessRules);
        return this;
    }

    public UseCaseConcept addBusinessRules(UseCaseBusinessRule useCaseBusinessRule) {
        this.businessRuleses.add(useCaseBusinessRule);
        useCaseBusinessRule.setUseCaseConcept(this);
        return this;
    }

    public UseCaseConcept removeBusinessRules(UseCaseBusinessRule useCaseBusinessRule) {
        this.businessRuleses.remove(useCaseBusinessRule);
        useCaseBusinessRule.setUseCaseConcept(null);
        return this;
    }

    public RequirementUseCaseConcepts getRequirementUseCaseConcepts() {
        return this.requirementUseCaseConcepts;
    }

    public void setRequirementUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.requirementUseCaseConcepts = requirementUseCaseConcepts;
    }

    public UseCaseConcept requirementUseCaseConcepts(RequirementUseCaseConcepts requirementUseCaseConcepts) {
        this.setRequirementUseCaseConcepts(requirementUseCaseConcepts);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseConcept)) {
            return false;
        }
        return getId() != null && getId().equals(((UseCaseConcept) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseConcept{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", trigger='" + getTrigger() + "'" +
            ", systemBoundary='" + getSystemBoundary() + "'" +
            "}";
    }
}
