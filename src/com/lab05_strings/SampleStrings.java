package com.lab05_strings;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 1. In each sentence of the text, swap the first word with the last word
 * without changing the length of the sentence.
 * 2. You need to create a string with text. Split this string into 2 substrings
 * of equal length and display each sentence on the screen from a new line.
 * 3. Output all sentences of a given text in order of increasing number of words in each of them.
 */
public class SampleStrings {

    public static void main(String[] args) {
        String text = new String("public final class StringBuilder\nextends Object\n"
                + "implements Serializable, CharSequence\n"
                + "A mutable sequence of characters. "
                + "This class provides an API compatible with StringBuffer, but with no guarantee of synchronization. "
                + "This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). "
                + "Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.The principal operations on a StringBuilder are the append and insert methods, which are overloaded so as to accept data of any type. "
                + "Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string builder. "
                + "The append method always adds these characters at the end of the builder; the insert method adds the characters at a specified point.For example, if z refers to a string builder object whose current contents are \"start\", then the method call z.append(\"le\") would cause the string builder to contain \"startle\", whereas z.insert(4, \"le\") would alter the string builder to contain \"starlet\".In general, if sb refers to an instance of a StringBuilder, then sb.append(x) has the same effect as sb.insert(sb.length(), x). "
                + "Every string builder has a capacity. "
                + "As long as the length of the character sequence contained in the string builder does not exceed the capacity, it is not necessary to allocate a new internal buffer. "
                + "If the internal buffer overflows, it is automatically made larger.Instances of StringBuilder are not safe for use by multiple threads. "
                + "If such synchronization is required then it is recommended that StringBuffer be used. ");

        StringBuilder nLineTxt = newLineSentences(text);
        System.out.println(nLineTxt);

        System.out.println("---Sorting by sentences length---");

        nLineTxt = sortByLength(nLineTxt);
        System.out.println(nLineTxt);

        System.out.println("---Replacing first and last words---");

        nLineTxt = replaceFirstLast(nLineTxt);
        System.out.println(nLineTxt);
    }

    private static StringBuilder sortByLength(StringBuilder str) {

        StringBuilder newText = new StringBuilder();
        int sentCount = 0;

        if ((sentCount = sentencesCount(str)) != 0) {
            StringBuilder[] sentArr = new StringBuilder[sentCount];

            int count = 0;
            int from = 0;
            int to = str.indexOf("\n");
            while (count != sentCount) {
                char[] sentence = new char[to - from];
                str.getChars(from, to, sentence, 0);
                sentArr[count] = new StringBuilder();
                sentArr[count++].append(sentence);

                from = ++to;
                to = str.indexOf("\n", from);
            }

            newText = sortSentences(sentArr);
        }

        return newText;
    }

    private static StringBuilder sortSentences(StringBuilder[] sentArr) {

        StringBuilder str = new StringBuilder();
        double factor = 1.247;
        int step = sentArr.length - 1;

        while (step >= 1) {
            for (int i = 0; i + step < sentArr.length; ++i) {
                if (sentArr[i].length() > sentArr[i + step].length()) {
                    StringBuilder buf = sentArr[i];
                    sentArr[i] = sentArr[i + step];
                    sentArr[i + step] = buf;
                }
            }

            step /= factor;
        }

        for (StringBuilder s : sentArr) {
            str.append(s.append("\n"));
        }

        return str;
    }

    private static int sentencesCount(StringBuilder str) {

        int counter = 0;

        int from = 0;
        int to = str.indexOf("\n");
        while (to != -1) {
            counter++;
            from = ++to;
            to = str.indexOf("\n", from);
        }

        return counter;
    }

    private static StringBuilder replaceFirstLast(StringBuilder str) {

        StringBuilder newText = new StringBuilder();
        int from = 0;
        int to = str.indexOf("\n");
        while (to != -1) {
            char[] sentence = new char[to - from];
            str.getChars(from, to, sentence, 0);
            StringBuilder buf = new StringBuilder();
            buf.append(sentence);
            newText.append(changeWords(buf)).append("\n");

            from = ++to;
            to = str.indexOf("\n", from);
        }

        return newText;
    }

    private static StringBuilder changeWords(StringBuilder str) {

        StringBuilder newText = new StringBuilder(str);

        int to1 = str.indexOf(" ");
        if (to1 != -1) {
            char[] fWord = new char[to1];
            str.getChars(0, to1, fWord, 0);

            int from2 = str.lastIndexOf(" ") + 1;
            int to2 = str.length();
            char[] lWord = new char[to2 - from2];
            str.getChars(from2, to2, lWord, 0);

            newText.delete(from2, to2);
            newText.append(fWord);
            newText.delete(0, to1);
            newText.insert(0, lWord);
        }

        return newText;
    }

    private static StringBuilder newLineSentences(String str) {
        Scanner sc = new Scanner(str);
        // pattern sets the conditions for the end of the line
        // (dot-space, dot-one or more characters to the end of the line)
        sc.useDelimiter(Pattern.compile("\\.\\s|\\.+$"));
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()){
            String sentence = sc.next().trim();
            sb.append(sentence).append("\n");
        }

        sc.close();
        return sb;
    }
}
