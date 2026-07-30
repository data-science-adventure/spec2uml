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
public class UseCaseActor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("description")
    private String description;
}
