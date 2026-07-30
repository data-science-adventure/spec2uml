package com.github.danimaniarqsoft.service.dto;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.UseCaseActorRef} entity.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UseCaseActorRefDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String actorName;

    private UseCaseConceptDTO primaryUseCaseConcept;

    private UseCaseConceptDTO secondaryUseCaseConcept;
}
