package com.github.danimaniarqsoft.service.dto;

import com.github.danimaniarqsoft.domain.enumeration.RequirementStatus;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.Requirement} entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RequirementDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @NotNull
    private Integer sentId;

    private String text;

    @NotNull
    private String source;

    @NotNull
    private String projectId;

    @NotNull
    private String type;

    @NotNull
    private String specLevel;

    private String classDiagram;

    private String useCaseDiagram;

    private RequirementStatus status;

    private Instant createdAt;

    private Instant updatedAt;

    private UserRefDTO createdBy;

    private RequirementUseCaseConceptsDTO useCaseConcepts;

    private RequirementClassConceptsDTO classConcepts;

    private ProjectDTO project;

    @Builder.Default
    private Set<UserRefDTO> annotatorses = new HashSet<>();
}
