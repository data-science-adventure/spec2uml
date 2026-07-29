package com.github.danimaniarqsoft.domain;

import static com.github.danimaniarqsoft.domain.ClassAttributeTestSamples.*;
import static com.github.danimaniarqsoft.domain.ClassConceptTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.danimaniarqsoft.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClassAttributeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassAttribute.class);
        ClassAttribute classAttribute1 = getClassAttributeSample1();
        ClassAttribute classAttribute2 = new ClassAttribute();
        assertThat(classAttribute1).isNotEqualTo(classAttribute2);

        classAttribute2.setId(classAttribute1.getId());
        assertThat(classAttribute1).isEqualTo(classAttribute2);

        classAttribute2 = getClassAttributeSample2();
        assertThat(classAttribute1).isNotEqualTo(classAttribute2);
    }

    @Test
    void classConceptTest() {
        ClassAttribute classAttribute = getClassAttributeRandomSampleGenerator();
        ClassConcept classConceptBack = getClassConceptRandomSampleGenerator();

        classAttribute.setClassConcept(classConceptBack);
        assertThat(classAttribute.getClassConcept()).isEqualTo(classConceptBack);

        classAttribute.classConcept(null);
        assertThat(classAttribute.getClassConcept()).isNull();
    }
}
