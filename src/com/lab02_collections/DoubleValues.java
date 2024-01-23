package com.lab02_collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Task:
 * 1. Enter 5 words in the list of strings.
 * 2. Using the doubleValues method, copy each word and paste it after it.
 * 3. Print the list, each word should be on a new line.
 */
public class DoubleValues {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter words till \"end\":");
            while (true) {
                String word = reader.readLine();
                if (word.equals("end")) break;
                if (!word.isEmpty()) list.add(word);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        doubleValues(list);

        for (String w : list) {
            System.out.println(w);
        }
    }

    private static void doubleValues(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }
}
