package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A OperationParameter.
 */
@Document(collection = "operation_parameter")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OperationParameter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("param_name")
    private String paramName;

    @Field("classOperation")
    @JsonIgnoreProperties(value = { "parameterses", "classConcept" }, allowSetters = true)
    private ClassOperation classOperation;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public OperationParameter id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParamName() {
        return this.paramName;
    }

    public OperationParameter paramName(String paramName) {
        this.setParamName(paramName);
        return this;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public ClassOperation getClassOperation() {
        return this.classOperation;
    }

    public void setClassOperation(ClassOperation classOperation) {
        this.classOperation = classOperation;
    }

    public OperationParameter classOperation(ClassOperation classOperation) {
        this.setClassOperation(classOperation);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OperationParameter)) {
            return false;
        }
        return getId() != null && getId().equals(((OperationParameter) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OperationParameter{" +
            "id=" + getId() +
            ", paramName='" + getParamName() + "'" +
            "}";
    }
}
