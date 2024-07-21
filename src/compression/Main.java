package compression;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Read input from file
        String inputText = compression.FileUtils.readFile("input.txt").trim(); // .trim() to remove extra newlines

        // Compress the text
        String compressedData = compression.HuffmanCompression.compress(inputText);

        // Write compressed data to file
        try (FileWriter writer = new FileWriter("compressed.txt")) {
            writer.write(compressedData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Decompress the data
        String decompressedData = compression.HuffmanCompression.decompress(compressedData);

        // Write decompressed data to file
        try (FileWriter writer = new FileWriter("decompressed.txt")) {
            writer.write(decompressedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
