package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassConceptDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String stereotype;
    private List<ClassAttributeDTO> attributes = new ArrayList<>();
    private List<ClassOperationDTO> operations = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStereotype() {
        return stereotype;
    }

    public void setStereotype(String stereotype) {
        this.stereotype = stereotype;
    }

    public List<ClassAttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ClassAttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public List<ClassOperationDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<ClassOperationDTO> operations) {
        this.operations = operations;
    }
}
