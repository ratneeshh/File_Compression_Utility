package compression;

public class HuffmanCompression {

    public static String compress(String text) {
        compression.Node root = compression.HuffmanTree.buildTree(text);
        compression.HuffmanTree.buildCodes(root, "");
        return compression.HuffmanTree.encode(text);
    }

    public static String decompress(String compressedText) {
        return compression.HuffmanTree.decode(compressedText);
    }
}
