package com.lab08_annotations.MathAnno;

import java.lang.reflect.Method;

/**
 * Create a custom annotation with @Repeatable. Use your annotation multiple times with different parameters.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = MathHandler.class.getMethod("addTwoNumbers", int.class, int.class);
        MathAnno[] sumAnnotations = method.getAnnotationsByType(MathAnno.class);

        for (var a : sumAnnotations) {
            System.out.println(a.num1() + " + " + a.num2() + " = " + (a.num1() + a.num2()));
        }
    }
}
