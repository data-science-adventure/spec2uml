package com.github.danimaniarqsoft.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequirementUseCaseConceptsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<UseCaseActorDTO> actors = new ArrayList<>();

    @JsonProperty("use_cases")
    private List<UseCaseConceptDTO> useCases = new ArrayList<>();

    private List<UseCaseRelationshipDTO> relationships = new ArrayList<>();

    public List<UseCaseActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<UseCaseActorDTO> actors) {
        this.actors = actors;
    }

    public List<UseCaseConceptDTO> getUseCases() {
        return useCases;
    }

    public void setUseCases(List<UseCaseConceptDTO> useCases) {
        this.useCases = useCases;
    }

    public List<UseCaseRelationshipDTO> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<UseCaseRelationshipDTO> relationships) {
        this.relationships = relationships;
    }
}
