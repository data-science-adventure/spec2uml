package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementUseCaseConcepts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("actors")
    @Builder.Default
    private List<UseCaseActor> actors = new ArrayList<>();

    @Field("use_cases")
    @Builder.Default
    private List<UseCaseConcept> useCases = new ArrayList<>();

    @Field("relationships")
    @Builder.Default
    private List<UseCaseRelationship> relationships = new ArrayList<>();

    public List<UseCaseActor> getActors() {
        if (this.actors == null) {
            this.actors = new ArrayList<>();
        }
        return this.actors;
    }

    public List<UseCaseConcept> getUseCases() {
        if (this.useCases == null) {
            this.useCases = new ArrayList<>();
        }
        return this.useCases;
    }

    public List<UseCaseRelationship> getRelationships() {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        return this.relationships;
    }
}
