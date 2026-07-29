package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.UseCaseBusinessRule} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseBusinessRuleDTO implements Serializable {

    private String id;

    private String ruleText;

    private UseCaseConceptDTO useCaseConcept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public UseCaseConceptDTO getUseCaseConcept() {
        return useCaseConcept;
    }

    public void setUseCaseConcept(UseCaseConceptDTO useCaseConcept) {
        this.useCaseConcept = useCaseConcept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseBusinessRuleDTO)) {
            return false;
        }

        UseCaseBusinessRuleDTO useCaseBusinessRuleDTO = (UseCaseBusinessRuleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, useCaseBusinessRuleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseBusinessRuleDTO{" +
            "id='" + getId() + "'" +
            ", ruleText='" + getRuleText() + "'" +
            ", useCaseConcept=" + getUseCaseConcept() +
            "}";
    }
}
