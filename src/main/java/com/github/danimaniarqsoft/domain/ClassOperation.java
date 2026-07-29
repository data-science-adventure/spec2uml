package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A ClassOperation.
 */
@Document(collection = "class_operation")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassOperation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("return_type")
    private String returnType;

    @Field("parameters")
    @JsonIgnoreProperties(value = { "classOperation" }, allowSetters = true)
    private Set<OperationParameter> parameterses = new HashSet<>();

    @Field("classConcept")
    @JsonIgnoreProperties(value = { "attributeses", "operationses", "requirementClassConcepts" }, allowSetters = true)
    private ClassConcept classConcept;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public ClassOperation id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public ClassOperation name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public ClassOperation returnType(String returnType) {
        this.setReturnType(returnType);
        return this;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Set<OperationParameter> getParameterses() {
        return this.parameterses;
    }

    public void setParameterses(Set<OperationParameter> operationParameters) {
        if (this.parameterses != null) {
            this.parameterses.forEach(i -> i.setClassOperation(null));
        }
        if (operationParameters != null) {
            operationParameters.forEach(i -> i.setClassOperation(this));
        }
        this.parameterses = operationParameters;
    }

    public ClassOperation parameterses(Set<OperationParameter> operationParameters) {
        this.setParameterses(operationParameters);
        return this;
    }

    public ClassOperation addParameters(OperationParameter operationParameter) {
        this.parameterses.add(operationParameter);
        operationParameter.setClassOperation(this);
        return this;
    }

    public ClassOperation removeParameters(OperationParameter operationParameter) {
        this.parameterses.remove(operationParameter);
        operationParameter.setClassOperation(null);
        return this;
    }

    public ClassConcept getClassConcept() {
        return this.classConcept;
    }

    public void setClassConcept(ClassConcept classConcept) {
        this.classConcept = classConcept;
    }

    public ClassOperation classConcept(ClassConcept classConcept) {
        this.setClassConcept(classConcept);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassOperation)) {
            return false;
        }
        return getId() != null && getId().equals(((ClassOperation) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassOperation{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", returnType='" + getReturnType() + "'" +
            "}";
    }
}
