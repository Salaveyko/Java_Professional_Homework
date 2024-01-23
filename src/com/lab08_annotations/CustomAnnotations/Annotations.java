package com.lab08_annotations.CustomAnnotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Annotation1 {
    String value() default "Annotation1";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@interface Annotation2 {
    int count() default 1;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Annotation3 {
    String[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@interface Annotation4 {
    boolean enabled() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Annotation5 {
    Class<?> type() default Object.class;
}