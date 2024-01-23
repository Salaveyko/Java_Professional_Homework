package com.lab02_collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Task: find the minimum value of N integers.
 * 1. Enter the value of N.
 * 2. Implement the getIntegerList() method, which should fill the list of N integers.
 * 3. Implement the getMinimum() method to return the minimum value from the list.
 */
public class GetMinimum {

    public static void main(String[] args) {

        System.out.print("Enter N: ");
        int n = new Scanner(System.in).nextInt();

        List<Integer> list = getIntegerList(n);

        System.out.println();
        for (Integer num : list) {
            System.out.println(num);
        }

        System.out.println("\nMinimal value: " + getMinimum(list));
    }

    private static List<Integer> getIntegerList(int n) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        System.out.println("Enet numbers");
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }

        return list;
    }

    private static Integer getMinimum(List<Integer> list) {
        if (!list.isEmpty()) {
            int min = list.get(0);
            for (int n : list) {
                if (min > n) min = n;
            }

            return min;
        } else {
            return null;
        }
    }
}
