package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.OperationParameter} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OperationParameterDTO implements Serializable {

    private String id;

    private String paramName;

    private ClassOperationDTO classOperation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public ClassOperationDTO getClassOperation() {
        return classOperation;
    }

    public void setClassOperation(ClassOperationDTO classOperation) {
        this.classOperation = classOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OperationParameterDTO)) {
            return false;
        }

        OperationParameterDTO operationParameterDTO = (OperationParameterDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, operationParameterDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OperationParameterDTO{" +
            "id='" + getId() + "'" +
            ", paramName='" + getParamName() + "'" +
            ", classOperation=" + getClassOperation() +
            "}";
    }
}
