package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Field;

public class UseCaseConcept implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("trigger")
    private String trigger;

    @Field("system_boundary")
    private String systemBoundary;

    @Field("primary_actors")
    private List<String> primaryActors = new ArrayList<>();

    @Field("secondary_actors")
    private List<String> secondaryActors = new ArrayList<>();

    @Field("preconditions")
    private List<String> preconditions = new ArrayList<>();

    @Field("postconditions")
    private List<String> postconditions = new ArrayList<>();

    @Field("business_rules")
    private List<String> businessRules = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getSystemBoundary() {
        return systemBoundary;
    }

    public void setSystemBoundary(String systemBoundary) {
        this.systemBoundary = systemBoundary;
    }

    public List<String> getPrimaryActors() {
        return primaryActors;
    }

    public void setPrimaryActors(List<String> primaryActors) {
        this.primaryActors = primaryActors;
    }

    public List<String> getSecondaryActors() {
        return secondaryActors;
    }

    public void setSecondaryActors(List<String> secondaryActors) {
        this.secondaryActors = secondaryActors;
    }

    public List<String> getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(List<String> preconditions) {
        this.preconditions = preconditions;
    }

    public List<String> getPostconditions() {
        return postconditions;
    }

    public void setPostconditions(List<String> postconditions) {
        this.postconditions = postconditions;
    }

    public List<String> getBusinessRules() {
        return businessRules;
    }

    public void setBusinessRules(List<String> businessRules) {
        this.businessRules = businessRules;
    }
}
