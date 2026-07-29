package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.UseCaseActorRef} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseActorRefDTO implements Serializable {

    private String id;

    @NotNull
    private String actorName;

    private UseCaseConceptDTO primaryUseCaseConcept;

    private UseCaseConceptDTO secondaryUseCaseConcept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public UseCaseConceptDTO getPrimaryUseCaseConcept() {
        return primaryUseCaseConcept;
    }

    public void setPrimaryUseCaseConcept(UseCaseConceptDTO primaryUseCaseConcept) {
        this.primaryUseCaseConcept = primaryUseCaseConcept;
    }

    public UseCaseConceptDTO getSecondaryUseCaseConcept() {
        return secondaryUseCaseConcept;
    }

    public void setSecondaryUseCaseConcept(UseCaseConceptDTO secondaryUseCaseConcept) {
        this.secondaryUseCaseConcept = secondaryUseCaseConcept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UseCaseActorRefDTO)) {
            return false;
        }

        UseCaseActorRefDTO useCaseActorRefDTO = (UseCaseActorRefDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, useCaseActorRefDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UseCaseActorRefDTO{" +
            "id='" + getId() + "'" +
            ", actorName='" + getActorName() + "'" +
            ", primaryUseCaseConcept=" + getPrimaryUseCaseConcept() +
            ", secondaryUseCaseConcept=" + getSecondaryUseCaseConcept() +
            "}";
    }
}
