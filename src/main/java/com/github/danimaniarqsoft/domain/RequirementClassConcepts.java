package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Embedded POJO for storing extracted UML class concepts inside Requirement.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementClassConcepts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("classes")
    @Builder.Default
    private List<ClassConcept> classes = new ArrayList<>();

    @Field("relationships")
    @Builder.Default
    private List<ClassRelationship> relationships = new ArrayList<>();

    @Field("confidence_score")
    private Double confidenceScore;

    public List<ClassConcept> getClasses() {
        if (this.classes == null) {
            this.classes = new ArrayList<>();
        }
        return this.classes;
    }

    public List<ClassRelationship> getRelationships() {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        return this.relationships;
    }
}
