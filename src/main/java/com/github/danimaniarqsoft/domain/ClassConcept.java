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
public class ClassConcept implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("stereotype")
    private String stereotype;

    @Field("attributes")
    @Builder.Default
    private List<ClassAttribute> attributes = new ArrayList<>();

    @Field("operations")
    @Builder.Default
    private List<ClassOperation> operations = new ArrayList<>();

    public List<ClassAttribute> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList<>();
        }
        return this.attributes;
    }

    public List<ClassOperation> getOperations() {
        if (this.operations == null) {
            this.operations = new ArrayList<>();
        }
        return this.operations;
    }
}
