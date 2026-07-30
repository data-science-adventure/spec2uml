package com.github.danimaniarqsoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.danimaniarqsoft.domain.enumeration.RequirementStatus;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Requirement domain entity.
 */
@Document(collection = "requirement")
@Getter
@Setter
@ToString(exclude = { "createdBy", "project", "annotatorses" })
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Requirement implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @NotNull
    @Field("sent_id")
    private Integer sentId;

    @Field("text")
    private String text;

    @NotNull
    @Field("source")
    private String source;

    @NotNull
    @Field("project_id")
    private String projectId;

    @NotNull
    @Field("type")
    private String type;

    @NotNull
    @Field("spec_level")
    private String specLevel;

    @Field("class_diagram")
    private String classDiagram;

    @Field("use_case_diagram")
    private String useCaseDiagram;

    @Field("useCaseConcepts")
    private RequirementUseCaseConcepts useCaseConcepts;

    @Field("classConcepts")
    @Builder.Default
    private RequirementClassConcepts classConcepts = new RequirementClassConcepts();

    @Field("status")
    private RequirementStatus status;

    @Field("created_at")
    private Instant createdAt;

    @Field("updated_at")
    private Instant updatedAt;

    @Field("createdBy")
    private UserRef createdBy;

    @Field("project")
    @JsonIgnoreProperties(value = { "statistics", "createdBy", "annotatorses", "reviewerses" }, allowSetters = true)
    private Project project;

    @Field("annotatorses")
    @Builder.Default
    private Set<UserRef> annotatorses = new HashSet<>();

    // Safeguard getter for collection
    public Set<UserRef> getAnnotatorses() {
        if (this.annotatorses == null) {
            this.annotatorses = new HashSet<>();
        }
        return this.annotatorses;
    }

    // Helper fluent methods for JHipster/domain relationships
    public Requirement addAnnotators(UserRef userRef) {
        getAnnotatorses().add(userRef);
        return this;
    }

    public Requirement removeAnnotators(UserRef userRef) {
        getAnnotatorses().remove(userRef);
        return this;
    }
}
