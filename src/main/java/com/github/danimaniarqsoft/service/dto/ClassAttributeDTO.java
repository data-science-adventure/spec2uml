package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;

public class ClassAttributeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
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
