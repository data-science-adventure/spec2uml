package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.ClassOperation} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClassOperationDTO implements Serializable {

    private String id;

    private String name;

    private String returnType;

    private ClassConceptDTO classConcept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public ClassConceptDTO getClassConcept() {
        return classConcept;
    }

    public void setClassConcept(ClassConceptDTO classConcept) {
        this.classConcept = classConcept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassOperationDTO)) {
            return false;
        }

        ClassOperationDTO classOperationDTO = (ClassOperationDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, classOperationDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClassOperationDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", returnType='" + getReturnType() + "'" +
            ", classConcept=" + getClassConcept() +
            "}";
    }
}
