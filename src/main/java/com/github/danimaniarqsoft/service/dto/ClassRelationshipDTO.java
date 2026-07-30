package com.github.danimaniarqsoft.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO representing a relationship between class concepts.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassRelationshipDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String source;
    private String target;
    private String type;

    @JsonProperty("sourceMultiplicity")
    private String sourceMultiplicity;

    @JsonProperty("targetMultiplicity")
    private String targetMultiplicity;

    private String label;
}
