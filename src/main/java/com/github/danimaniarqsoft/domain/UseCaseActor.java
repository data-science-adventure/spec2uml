package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Field;

public class UseCaseActor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
