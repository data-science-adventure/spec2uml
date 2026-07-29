package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A UseCaseBusinessRule.
 */
@Document(collection = "use_case_business_rule")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseBusinessRule implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("rule_text")
    private String ruleText;

    @Field("useCaseConcept")
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
    private UseCaseConcept useCaseConcept;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public UseCaseBusinessRule id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleText() {
        return this.ruleText;
    }

    public UseCaseBusinessRule ruleText(String ruleText) {
        this.setRuleText(ruleText);
        return this;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public UseCaseConcept getUseCaseConcept() {
        return this.useCaseConcept;
    }

    public void setUseCaseConcept(UseCaseConcept useCaseConcept) {
        this.useCaseConcept = useCaseConcept;
    }

    public UseCaseBusinessRule useCaseConcept(UseCaseConcept useCaseConcept) {
        this.setUseCaseConcept(useCaseConcept);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseBusinessRule)) {
            return false;
        }
        return getId() != null && getId().equals(((UseCaseBusinessRule) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseBusinessRule{" +
            "id=" + getId() +
            ", ruleText='" + getRuleText() + "'" +
            "}";
    }
}
