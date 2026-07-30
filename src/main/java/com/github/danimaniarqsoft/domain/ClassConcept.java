package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Field;

public class ClassConcept implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("stereotype")
    private String stereotype;

    @Field("attributes")
    private List<ClassAttribute> attributes = new ArrayList<>();

    @Field("operations")
    private List<ClassOperation> operations = new ArrayList<>();

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

    public List<ClassAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ClassAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<ClassOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<ClassOperation> operations) {
        this.operations = operations;
    }
}
