package com.github.danimaniarqsoft.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO representing class concepts extracted from requirement text.
 */
public class RequirementClassConceptsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ClassConceptDTO> classes = new ArrayList<>();

    private List<ClassRelationshipDTO> relationships = new ArrayList<>();

    @JsonProperty("confidence_score")
    private Double confidenceScore;

    public List<ClassConceptDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassConceptDTO> classes) {
        this.classes = classes;
    }

    public List<ClassRelationshipDTO> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<ClassRelationshipDTO> relationships) {
        this.relationships = relationships;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
