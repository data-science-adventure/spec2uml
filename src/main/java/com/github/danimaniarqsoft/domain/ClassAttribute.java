package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Field;

public class ClassAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("name")
    private String name;

    @Field("type")
    private String type;

    @Field("visibility")
    private String visibility;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
