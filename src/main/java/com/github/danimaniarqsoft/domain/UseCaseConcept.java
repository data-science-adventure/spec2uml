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
    @Builder.Default
    private List<String> primaryActors = new ArrayList<>();

    @Field("secondary_actors")
    @Builder.Default
    private List<String> secondaryActors = new ArrayList<>();

    @Field("preconditions")
    @Builder.Default
    private List<String> preconditions = new ArrayList<>();

    @Field("postconditions")
    @Builder.Default
    private List<String> postconditions = new ArrayList<>();

    @Field("business_rules")
    @Builder.Default
    private List<String> businessRules = new ArrayList<>();

    public List<String> getPrimaryActors() {
        if (this.primaryActors == null) this.primaryActors = new ArrayList<>();
        return this.primaryActors;
    }

    public List<String> getSecondaryActors() {
        if (this.secondaryActors == null) this.secondaryActors = new ArrayList<>();
        return this.secondaryActors;
    }

    public List<String> getPreconditions() {
        if (this.preconditions == null) this.preconditions = new ArrayList<>();
        return this.preconditions;
    }

    public List<String> getPostconditions() {
        if (this.postconditions == null) this.postconditions = new ArrayList<>();
        return this.postconditions;
    }

    public List<String> getBusinessRules() {
        if (this.businessRules == null) this.businessRules = new ArrayList<>();
        return this.businessRules;
    }
}
