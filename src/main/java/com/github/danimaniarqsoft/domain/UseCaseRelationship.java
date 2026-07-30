package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UseCaseRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("source")
    private String source;

    @Field("target")
    private String target;

    @Field("type")
    private String type;

    @Field("label")
    private String label;
}
