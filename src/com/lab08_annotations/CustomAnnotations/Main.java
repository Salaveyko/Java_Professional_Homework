package com.lab08_annotations.CustomAnnotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Create 5 different annotations with different parameters and types.
 * Create a base class and a derived class that extends base class.
 * Annotate both classes with your own annotations.
 * Print the results.
 */
public class Main {
    public static void main(String[] args) {
        Class<?> base = Base.class;
        Class<?> derived = Derived.class;

        printAnnotations(base);
        System.out.println("-------");
        printAnnotations(derived);
    }

    private static void printAnnotations(Class<?> clazz) {
        StringBuilder sb = new StringBuilder("Annotations of the " + clazz.getSimpleName());
        sb.append("\n").append(getAnnotationsString(clazz.getAnnotations()));

        sb.append("\n").append(clazz.getSimpleName()).append("`s fields annotations:").append("\n");
        for (var f : clazz.getDeclaredFields()) {
            Annotation[] anns = f.getAnnotations();
            if (anns.length == 0) continue;
            sb.append(getAnnotationsString(anns)).append(f.getName()).append("\n");
        }

        sb.append("\n").append(clazz.getSimpleName()).append("`s methods annotations:").append("\n");
        for (var m : clazz.getMethods()) {
            Annotation[] anns = m.getAnnotations();
            if (anns.length == 0) continue;
            sb.append(getAnnotationsString(anns)).append(m.getName()).append("\n");
        }

        System.out.println(sb);
    }

    private static StringBuilder getAnnotationsString(Annotation[] annotations) {
        StringBuilder sb = new StringBuilder();

        for (var a : annotations) {
            sb.append("@").append(a.annotationType().getSimpleName())
                    .append(getAnnotationsValues(a)).append("\n");
        }

        return sb;
    }

    private static StringBuilder getAnnotationsValues(Annotation annotation) {
        StringBuilder sb = new StringBuilder();

        if (annotation instanceof Annotation1) {
            return sb.append("(value = ").append(((Annotation1) annotation).value()).append(")");
        }
        if (annotation instanceof Annotation2) {
            return sb.append("(count = ").append(((Annotation2) annotation).count()).append(")");
        }
        if (annotation instanceof Annotation3) {
            return sb.append("(values = ")
                    .append(Arrays.toString(((Annotation3) annotation).value())).append(")");
        }
        if (annotation instanceof Annotation4) {
            return sb.append("(enabled = ").append(((Annotation4) annotation).enabled()).append(")");
        }
        if (annotation instanceof Annotation5) {
            return sb.append("(type = ").append(((Annotation5) annotation).type()).append(")");
        }

        return sb;
    }
}
