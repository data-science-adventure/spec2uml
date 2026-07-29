package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A UseCaseCondition.
 */
@Document(collection = "use_case_condition")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseCondition implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("condition_text")
    private String conditionText;

    @Field("preconditionUseCaseConcept")
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
    private UseCaseConcept preconditionUseCaseConcept;

    @Field("postconditionUseCaseConcept")
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
    private UseCaseConcept postconditionUseCaseConcept;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UseCaseCondition id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public UseCaseCondition conditionText(String conditionText) {
        this.setConditionText(conditionText);
        return this;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public UseCaseConcept getPreconditionUseCaseConcept() {
        return this.preconditionUseCaseConcept;
    }

    public void setPreconditionUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.preconditionUseCaseConcept = useCaseConcept;
    }

    public UseCaseCondition preconditionUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.setPreconditionUseCaseConcept(useCaseConcept);
        return this;
    }

    public UseCaseConcept getPostconditionUseCaseConcept() {
        return this.postconditionUseCaseConcept;
    }

    public void setPostconditionUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.postconditionUseCaseConcept = useCaseConcept;
    }

    public UseCaseCondition postconditionUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.setPostconditionUseCaseConcept(useCaseConcept);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseCondition)) {
            return false;
        }
        return getId() != null && getId().equals(((UseCaseCondition) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseCondition{" +
            "id=" + getId() +
            ", conditionText='" + getConditionText() + "'" +
            "}";
    }
}
