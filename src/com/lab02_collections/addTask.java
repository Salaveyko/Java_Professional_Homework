package com.lab02_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Task:
 * 1. Create a list of strings.
 * 2. Enter a strings and add them to the list. The user must enter "end" to complete.
 * 3. Print the list, each element should be printed at a new line.
 */
public class addTask {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        System.out.println("Enter words till \"end\":");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String word = sc.nextLine();
            if (word.isEmpty()) continue;
            if (word.equals("end")) break;
            list.add(word);
        }

        System.out.println();

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
