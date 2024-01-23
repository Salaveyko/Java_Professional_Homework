package com.lab08_annotations.CustomAnnotations;

@Annotation1
public class Base {
    @Annotation2(count = 5)
    protected int value;

    @Annotation3(value = {"Hello", "annotations"})
    public void method1(){
    }
}
