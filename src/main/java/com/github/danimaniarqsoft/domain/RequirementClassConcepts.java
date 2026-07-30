package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Embedded POJO for storing extracted UML class concepts inside Requirement.
 */
public class RequirementClassConcepts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("classes")
    private List<ClassConcept> classes = new ArrayList<>();

    @Field("relationships")
    private List<ClassRelationship> relationships = new ArrayList<>();

    @Field("confidence_score")
    private Double confidenceScore;

    public List<ClassConcept> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassConcept> classes) {
        this.classes = classes;
    }

    public List<ClassRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<ClassRelationship> relationships) {
        this.relationships = relationships;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
