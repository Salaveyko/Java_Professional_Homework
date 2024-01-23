package com.lab08_annotations.CustomAnnotations;

@Annotation4
public class Derived extends Base{

    @Annotation5(type = String.class)
    public void method2(){
    }
}
