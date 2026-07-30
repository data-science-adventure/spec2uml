package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO representing a Use Case Relationship concept.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UseCaseRelationshipDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String source;
    private String target;
    private String type;
    private String label;
}
