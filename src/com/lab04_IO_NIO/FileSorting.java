package com.lab04_IO_NIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creating the 'file.data' and write integers to it.
 * Reading data from a file and sorting it.
 */
public class FileSorting {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + File.separator + "Data"
                + File.separator + "04Lab" + File.separator + "sortingIntegers.data");

        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Directories have been created: " + parentDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create directories: " + parentDir.getAbsolutePath());
            }
        }
        if (!(file.exists())) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File " + file.getName() + " have been created");
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        byte[] bites = {5, 3, 4, 2, 1, 1, 7};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {

            for (byte b : bites) {
                dos.writeByte(b);
            }
            dos.flush();

            List<Integer> dataList = new ArrayList<>();
            try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
                while (dis.available() > 0) {
                    int val = dis.readByte();
                    dataList.add(val);
                }
            }
            System.out.println("Data read from the '" + file.getName() + "' file:\n" + dataList);

            Collections.sort(dataList);
            System.out.println("Sorted list: " + dataList);

        } catch (IOException ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
        }
    }

}
