package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Field;

public class RequirementUseCaseConcepts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("actors")
    private List<UseCaseActor> actors = new ArrayList<>();

    @Field("use_cases")
    private List<UseCaseConcept> useCases = new ArrayList<>();

    @Field("relationships")
    private List<UseCaseRelationship> relationships = new ArrayList<>();

    public List<UseCaseActor> getActors() {
        return actors;
    }

    public void setActors(List<UseCaseActor> actors) {
        this.actors = actors;
    }

    public List<UseCaseConcept> getUseCases() {
        return useCases;
    }

    public void setUseCases(List<UseCaseConcept> useCases) {
        this.useCases = useCases;
    }

    public List<UseCaseRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<UseCaseRelationship> relationships) {
        this.relationships = relationships;
    }
}
