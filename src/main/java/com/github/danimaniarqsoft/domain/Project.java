package com.github.danimaniarqsoft.domain;

import com.github.danimaniarqsoft.domain.enumeration.Language;
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
 * A Project domain entity.
 */
@Document(collection = "project")
@Getter
@Setter
@ToString(exclude = { "createdBy", "annotatorses", "reviewerses" })
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Project implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @NotNull
    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @NotNull
    @Field("language")
    private Language language;

    @Field("uml_version")
    private String umlVersion;

    @NotNull
    @Field("created_at")
    private Instant createdAt;

    @Field("updated_at")
    private Instant updatedAt;

    @Field("createdBy")
    private User createdBy;

    @Field("annotatorses")
    @Builder.Default
    private Set<User> annotatorses = new HashSet<>();

    @Field("reviewerses")
    @Builder.Default
    private Set<User> reviewerses = new HashSet<>();

    // Defensive getter for annotatorses to prevent NullPointerExceptions
    public Set<User> getAnnotatorses() {
        if (this.annotatorses == null) {
            this.annotatorses = new HashSet<>();
        }
        return this.annotatorses;
    }

    // Defensive getter for reviewerses to prevent NullPointerExceptions
    public Set<User> getReviewerses() {
        if (this.reviewerses == null) {
            this.reviewerses = new HashSet<>();
        }
        return this.reviewerses;
    }

    // Domain helper methods for managing relations
    public Project addAnnotators(User user) {
        getAnnotatorses().add(user);
        return this;
    }

    public Project removeAnnotators(User user) {
        getAnnotatorses().remove(user);
        return this;
    }

    public Project addReviewers(User user) {
        getReviewerses().add(user);
        return this;
    }

    public Project removeReviewers(User user) {
        getReviewerses().remove(user);
        return this;
    }
}
