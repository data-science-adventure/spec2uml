package com.github.danimaniarqsoft.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UseCaseConceptDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String description;

    @JsonProperty("primary_actors")
    private List<String> primaryActors = new ArrayList<>();

    @JsonProperty("secondary_actors")
    private List<String> secondaryActors = new ArrayList<>();

    private List<String> preconditions = new ArrayList<>();
    private List<String> postconditions = new ArrayList<>();
    private String trigger;

    @JsonProperty("system_boundary")
    private String systemBoundary;

    @JsonProperty("business_rules")
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

    public List<String> getBusinessRules() {
        return businessRules;
    }

    public void setBusinessRules(List<String> businessRules) {
        this.businessRules = businessRules;
    }
}
