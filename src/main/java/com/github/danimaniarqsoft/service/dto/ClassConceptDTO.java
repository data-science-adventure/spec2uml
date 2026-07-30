package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO representing a Class Concept.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassConceptDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String stereotype;

    @Builder.Default
    private List<ClassAttributeDTO> attributes = new ArrayList<>();

    @Builder.Default
    private List<ClassOperationDTO> operations = new ArrayList<>();

    // Defensive getters to prevent NullPointerExceptions during stream operations or mappings
    public List<ClassAttributeDTO> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList<>();
        }
        return this.attributes;
    }

    public List<ClassOperationDTO> getOperations() {
        if (this.operations == null) {
            this.operations = new ArrayList<>();
        }
        return this.operations;
    }
}
