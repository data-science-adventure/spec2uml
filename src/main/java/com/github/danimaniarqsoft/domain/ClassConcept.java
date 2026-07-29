package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A ClassConcept.
 */
@Document(collection = "class_concept")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassConcept implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @Field("stereotype")
    private String stereotype;

    @Field("attributes")
    @JsonIgnoreProperties(value = { "classConcept" }, allowSetters = true)
    private Set<ClassAttribute> attributeses = new HashSet<>();

    @Field("operations")
    @JsonIgnoreProperties(value = { "parameterses", "classConcept" }, allowSetters = true)
    private Set<ClassOperation> operationses = new HashSet<>();

    @Field("requirementClassConcepts")
    @JsonIgnoreProperties(value = { "classeses", "relationshipses" }, allowSetters = true)
    private RequirementClassConcepts requirementClassConcepts;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public ClassConcept id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public ClassConcept name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStereotype() {
        return this.stereotype;
    }

    public ClassConcept stereotype(String stereotype) {
        this.setStereotype(stereotype);
        return this;
    }

    public void setStereotype(String stereotype) {
        this.stereotype = stereotype;
    }

    public Set<ClassAttribute> getAttributeses() {
        return this.attributeses;
    }

    public void setAttributeses(Set<ClassAttribute> classAttributes) {
        if (this.attributeses != null) {
            this.attributeses.forEach(i -> i.setClassConcept(null));
        }
        if (classAttributes != null) {
            classAttributes.forEach(i -> i.setClassConcept(this));
        }
        this.attributeses = classAttributes;
    }

    public ClassConcept attributeses(Set<ClassAttribute> classAttributes) {
        this.setAttributeses(classAttributes);
        return this;
    }

    public ClassConcept addAttributes(ClassAttribute classAttribute) {
        this.attributeses.add(classAttribute);
        classAttribute.setClassConcept(this);
        return this;
    }

    public ClassConcept removeAttributes(ClassAttribute classAttribute) {
        this.attributeses.remove(classAttribute);
        classAttribute.setClassConcept(null);
        return this;
    }

    public Set<ClassOperation> getOperationses() {
        return this.operationses;
    }

    public void setOperationses(Set<ClassOperation> classOperations) {
        if (this.operationses != null) {
            this.operationses.forEach(i -> i.setClassConcept(null));
        }
        if (classOperations != null) {
            classOperations.forEach(i -> i.setClassConcept(this));
        }
        this.operationses = classOperations;
    }

    public ClassConcept operationses(Set<ClassOperation> classOperations) {
        this.setOperationses(classOperations);
        return this;
    }

    public ClassConcept addOperations(ClassOperation classOperation) {
        this.operationses.add(classOperation);
        classOperation.setClassConcept(this);
        return this;
    }

    public ClassConcept removeOperations(ClassOperation classOperation) {
        this.operationses.remove(classOperation);
        classOperation.setClassConcept(null);
        return this;
    }

    public RequirementClassConcepts getRequirementClassConcepts() {
        return this.requirementClassConcepts;
    }

    public void setRequirementClassConcepts(RequirementClassConcepts requirementClassConcepts) {
        this.requirementClassConcepts = requirementClassConcepts;
    }

    public ClassConcept requirementClassConcepts(RequirementClassConcepts requirementClassConcepts) {
        this.setRequirementClassConcepts(requirementClassConcepts);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassConcept)) {
            return false;
        }
        return getId() != null && getId().equals(((ClassConcept) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassConcept{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", stereotype='" + getStereotype() + "'" +
            "}";
    }
}
