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
 * A DTO representing a Use Case Concept.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UseCaseConceptDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String description;

    @JsonProperty("primary_actors")
    @Builder.Default
    private List<String> primaryActors = new ArrayList<>();

    @JsonProperty("secondary_actors")
    @Builder.Default
    private List<String> secondaryActors = new ArrayList<>();

    @Builder.Default
    private List<String> preconditions = new ArrayList<>();

    @Builder.Default
    private List<String> postconditions = new ArrayList<>();

    private String trigger;

    @JsonProperty("system_boundary")
    private String systemBoundary;

    @JsonProperty("business_rules")
    @Builder.Default
    private List<String> businessRules = new ArrayList<>();

    // Defensive getters to prevent NullPointerExceptions during stream operations or mappings
    public List<String> getPrimaryActors() {
        if (this.primaryActors == null) {
            this.primaryActors = new ArrayList<>();
        }
        return this.primaryActors;
    }

    public List<String> getSecondaryActors() {
        if (this.secondaryActors == null) {
            this.secondaryActors = new ArrayList<>();
        }
        return this.secondaryActors;
    }

    public List<String> getPreconditions() {
        if (this.preconditions == null) {
            this.preconditions = new ArrayList<>();
        }
        return this.preconditions;
    }

    public List<String> getPostconditions() {
        if (this.postconditions == null) {
            this.postconditions = new ArrayList<>();
        }
        return this.postconditions;
    }

    public List<String> getBusinessRules() {
        if (this.businessRules == null) {
            this.businessRules = new ArrayList<>();
        }
        return this.businessRules;
    }
}
