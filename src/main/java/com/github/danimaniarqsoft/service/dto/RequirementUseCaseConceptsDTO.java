package com.github.danimaniarqsoft.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO representing Use Case concepts for a Requirement.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementUseCaseConceptsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Builder.Default
    private List<UseCaseActorDTO> actors = new ArrayList<>();

    @JsonProperty("use_cases")
    @Builder.Default
    private List<UseCaseConceptDTO> useCases = new ArrayList<>();

    @Builder.Default
    private List<UseCaseRelationshipDTO> relationships = new ArrayList<>();

    // Defensive getters to prevent NullPointerExceptions during stream operations or mappings
    public List<UseCaseActorDTO> getActors() {
        if (this.actors == null) {
            this.actors = new ArrayList<>();
        }
        return this.actors;
    }

    public List<UseCaseConceptDTO> getUseCases() {
        if (this.useCases == null) {
            this.useCases = new ArrayList<>();
        }
        return this.useCases;
    }

    public List<UseCaseRelationshipDTO> getRelationships() {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        return this.relationships;
    }
}
