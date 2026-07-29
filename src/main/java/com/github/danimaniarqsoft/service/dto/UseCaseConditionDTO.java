package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.UseCaseCondition} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseConditionDTO implements Serializable {

    private String id;

    private String conditionText;

    private UseCaseConceptDTO preconditionUseCaseConcept;

    private UseCaseConceptDTO postconditionUseCaseConcept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public UseCaseConceptDTO getPreconditionUseCaseConcept() {
        return preconditionUseCaseConcept;
    }

    public void setPreconditionUseCaseConcept(UseCaseConceptDTO preconditionUseCaseConcept) {
        this.preconditionUseCaseConcept = preconditionUseCaseConcept;
    }

    public UseCaseConceptDTO getPostconditionUseCaseConcept() {
        return postconditionUseCaseConcept;
    }

    public void setPostconditionUseCaseConcept(UseCaseConceptDTO postconditionUseCaseConcept) {
        this.postconditionUseCaseConcept = postconditionUseCaseConcept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseConditionDTO)) {
            return false;
        }

        UseCaseConditionDTO useCaseConditionDTO = (UseCaseConditionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, useCaseConditionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseConditionDTO{" +
            "id='" + getId() + "'" +
            ", conditionText='" + getConditionText() + "'" +
            ", preconditionUseCaseConcept=" + getPreconditionUseCaseConcept() +
            ", postconditionUseCaseConcept=" + getPostconditionUseCaseConcept() +
            "}";
    }
}
