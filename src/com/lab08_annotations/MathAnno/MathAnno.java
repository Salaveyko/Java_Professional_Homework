package com.lab08_annotations.MathAnno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MathAnnos {
    MathAnno[] value();
}

@Repeatable(MathAnnos.class)
@Retention(RetentionPolicy.RUNTIME)
@interface MathAnno {
    int num1() default 0;

    int num2() default 0;
}
