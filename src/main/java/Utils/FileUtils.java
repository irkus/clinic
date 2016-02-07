package Utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by iushakova on 17/11/15.
 */
public class FileUtils {

    public static void appendToFile(String filename, String str) {
        writeToFile(filename, str, true);
    }

    public static void addToFile(String filename, String str) {
        writeToFile(filename, str, false);
    }

    private static void writeToFile(String filename, String str, boolean isAppend) {

        try (FileOutputStream os = new FileOutputStream(filename, isAppend);
             BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            bf.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String filename) {
        try {
            Files.delete(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
