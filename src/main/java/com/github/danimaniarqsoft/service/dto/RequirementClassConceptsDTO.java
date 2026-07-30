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
 * DTO representing class concepts extracted from requirement text.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementClassConceptsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Builder.Default
    private List<ClassConceptDTO> classes = new ArrayList<>();

    @Builder.Default
    private List<ClassRelationshipDTO> relationships = new ArrayList<>();

    @JsonProperty("confidence_score")
    private Double confidenceScore;

    // Defensive getters to prevent NullPointerExceptions during stream operations or mappings
    public List<ClassConceptDTO> getClasses() {
        if (this.classes == null) {
            this.classes = new ArrayList<>();
        }
        return this.classes;
    }

    public List<ClassRelationshipDTO> getRelationships() {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        return this.relationships;
    }
}
