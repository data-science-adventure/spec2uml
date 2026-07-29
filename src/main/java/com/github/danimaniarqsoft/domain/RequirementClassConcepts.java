package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A RequirementClassConcepts.
 */
@Document(collection = "requirement_class_concepts")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RequirementClassConcepts implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("classes")
    @JsonIgnoreProperties(value = { "attributeses", "operationses", "requirementClassConcepts" }, allowSetters = true)
    private Set<ClassConcept> classeses = new HashSet<>();

    @Field("relationships")
    @JsonIgnoreProperties(value = { "requirementClassConcepts" }, allowSetters = true)
    private Set<ClassRelationship> relationshipses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public RequirementClassConcepts id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<ClassConcept> getClasseses() {
        return this.classeses;
    }

    public void setClasseses(Set<ClassConcept> classConcepts) {
        if (this.classeses != null) {
            this.classeses.forEach(i -> i.setRequirementClassConcepts(null));
        }
        if (classConcepts != null) {
            classConcepts.forEach(i -> i.setRequirementClassConcepts(this));
        }
        this.classeses = classConcepts;
    }

    public RequirementClassConcepts classeses(Set<ClassConcept> classConcepts) {
        this.setClasseses(classConcepts);
        return this;
    }

    public RequirementClassConcepts addClasses(ClassConcept classConcept) {
        this.classeses.add(classConcept);
        classConcept.setRequirementClassConcepts(this);
        return this;
    }

    public RequirementClassConcepts removeClasses(ClassConcept classConcept) {
        this.classeses.remove(classConcept);
        classConcept.setRequirementClassConcepts(null);
        return this;
    }

    public Set<ClassRelationship> getRelationshipses() {
        return this.relationshipses;
    }

    public void setRelationshipses(Set<ClassRelationship> classRelationships) {
        if (this.relationshipses != null) {
            this.relationshipses.forEach(i -> i.setRequirementClassConcepts(null));
        }
        if (classRelationships != null) {
            classRelationships.forEach(i -> i.setRequirementClassConcepts(this));
        }
        this.relationshipses = classRelationships;
    }

    public RequirementClassConcepts relationshipses(Set<ClassRelationship> classRelationships) {
        this.setRelationshipses(classRelationships);
        return this;
    }

    public RequirementClassConcepts addRelationships(ClassRelationship classRelationship) {
        this.relationshipses.add(classRelationship);
        classRelationship.setRequirementClassConcepts(this);
        return this;
    }

    public RequirementClassConcepts removeRelationships(ClassRelationship classRelationship) {
        this.relationshipses.remove(classRelationship);
        classRelationship.setRequirementClassConcepts(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequirementClassConcepts)) {
            return false;
        }
        return getId() != null && getId().equals(((RequirementClassConcepts) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RequirementClassConcepts{" +
            "id=" + getId() +
            "}";
    }
}
