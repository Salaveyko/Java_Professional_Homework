package com.lab04_IO_NIO;

import java.io.*;
import java.util.Scanner;

/**
 * Create a new file and write data to it.
 * Read the file and print the data.
 */
public class DataInOut {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + File.separator + "Data"
                + File.separator + "04Lab" + File.separator + "randomValues.txt");

        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Directories have been created: " + parentDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create directories: " + parentDir.getAbsolutePath());
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

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), "Cp866"))) {

            Scanner sc = new Scanner(System.in);
            StringBuilder data = new StringBuilder();

            System.out.println("Enter 'end' when you are done.");
            while (true) {
                String line = sc.nextLine();
                if(line.equals("end")) break;
                if(!line.isEmpty()){
                    data.append(line).append("\n");
                }
            }

            System.out.println("Writing data to the file.");
            writer.write(data.toString());
            writer.flush();
            System.out.println("Writing complete.");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "Cp866"))) {

            System.out.println("\nReading data from the file...");
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("Reading complete.");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
