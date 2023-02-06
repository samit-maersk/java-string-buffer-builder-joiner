package net.java.chapter;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

class FileWriter {
    private static void test() throws Exception {
        // @start region="writeFile"
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(""))) {
            writer.write("");
        }
        // @end
    }
}
