package com.github.danimaniarqsoft.service.dto;

import java.io.Serializable;

public class UseCaseRelationshipDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String source;
    private String target;
    private String type;
    private String label;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
