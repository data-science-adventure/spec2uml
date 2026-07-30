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
public class ClassOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("return_type")
    private String returnType;

    @Field("parameters")
    @Builder.Default
    private List<String> parameters = new ArrayList<>();

    public List<String> getParameters() {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        return this.parameters;
    }
}
