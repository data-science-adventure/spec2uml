package com.github.danimaniarqsoft.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO representing a Class Operation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassOperationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @Builder.Default
    private List<String> parameters = new ArrayList<>();

    @JsonProperty("return_type")
    private String returnType;

    // Defensive getter to prevent NullPointerExceptions during stream operations or mappings
    public List<String> getParameters() {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        return this.parameters;
    }
}
