package com.lab08_annotations.MathAnno;

public class MathHandler {
    
    @MathAnno(num1 = 50, num2 = 3)
    @MathAnno(num2 = 100)
    public int addTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }
}
