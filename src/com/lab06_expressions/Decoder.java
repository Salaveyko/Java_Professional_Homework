package com.lab06_expressions;

import java.io.*;

/**
 * A funny decoder replaces prepositions in the text read from 'input.txt' with the word "Java"
 * and saves the changes in the 'output.txt'
 */
public class Decoder {
    public static void main(String[] args) {
        File inputFile = new File(System.getProperty("user.dir") + File.separator + "Data"
                + File.separator + "06Lab" + File.separator + "input.txt");
        File outputFile = new File(System.getProperty("user.dir") + File.separator + "Data"
                + File.separator + "06Lab" + File.separator + "output.txt");

        mkDirs(inputFile);
        mkDirs(outputFile);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            String[] prepositions = {"in", "on", "under", "with", "through", "at", "between"};

            while ((line = reader.readLine()) != null) {

                for (String preposition : prepositions) {
                    line = line.replaceAll("\\b" + preposition + "\\b|\\b"
                                    + Character.toUpperCase(preposition.charAt(0))
                                    + preposition.substring(1) + "\\b",
                            "Java");
                }
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Complete. Changes saved into "
                    + outputFile.getAbsolutePath() + " file. Just look :)");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void mkDirs(File file) {
        File prntDir = file.getParentFile();
        if (!prntDir.exists()) {
            if (prntDir.mkdirs()) {
                System.out.println("Directories have been created: " + prntDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create directories: " + prntDir.getAbsolutePath());
            }
        }
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File " + file.getName() + " have been created");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
