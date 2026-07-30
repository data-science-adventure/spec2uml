package com.github.danimaniarqsoft.service.dto;

import com.github.danimaniarqsoft.domain.enumeration.Language;
import jakarta.validation.constraints.NotNull;
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

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.Project} entity.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private String id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Language language;

    private String umlVersion;

    private Instant createdAt;

    private Instant updatedAt;

    private UserDTO createdBy;

    @Builder.Default
    private Set<UserDTO> annotatorses = new HashSet<>();

    @Builder.Default
    private Set<UserDTO> reviewerses = new HashSet<>();

    // Defensive getter for annotatorses to prevent NullPointerExceptions
    public Set<UserDTO> getAnnotatorses() {
        if (this.annotatorses == null) {
            this.annotatorses = new HashSet<>();
        }
        return this.annotatorses;
    }

    // Defensive getter for reviewerses to prevent NullPointerExceptions
    public Set<UserDTO> getReviewerses() {
        if (this.reviewerses == null) {
            this.reviewerses = new HashSet<>();
        }
        return this.reviewerses;
    }
}
