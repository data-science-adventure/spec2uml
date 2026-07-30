package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Field;

public class ClassRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("source")
    private String source;

    @Field("target")
    private String target;

    @Field("type")
    private String type;

    @Field("source_multiplicity")
    private String sourceMultiplicity;

    @Field("target_multiplicity")
    private String targetMultiplicity;

    @Field("label")
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

    public String getSourceMultiplicity() {
        return sourceMultiplicity;
    }

    public void setSourceMultiplicity(String sourceMultiplicity) {
        this.sourceMultiplicity = sourceMultiplicity;
    }

    public String getTargetMultiplicity() {
        return targetMultiplicity;
    }

    public void setTargetMultiplicity(String targetMultiplicity) {
        this.targetMultiplicity = targetMultiplicity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
