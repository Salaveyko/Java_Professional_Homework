package com.lab09_serialization.builder;

import java.io.File;
import java.io.IOException;

public class FileBuilder {
    public static File build(String fileName) {
        File file = new File(System.getProperty("user.dir") + File.separator + "Data"
                + File.separator + "09Lab" + File.separator + fileName);
        mkDirs(file);

        return file;
    }

    private static void mkDirs(File file) {
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
