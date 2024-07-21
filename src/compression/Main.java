package compression;

public class Main {
    public static void main(String[] args) {
        String text = "this is an example for huffman encoding";
        compression.HuffmanCompression huffmanCompression = new compression.HuffmanCompression(text);

        String compressed = huffmanCompression.compress(text);
        System.out.println("Compressed: " + compressed);

        String decompressed = huffmanCompression.decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}
