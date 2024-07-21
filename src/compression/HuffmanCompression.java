package compression;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCompression {
    private Map<Character, String> huffmanCodeMap;
    private compression.Node root;

    public HuffmanCompression(String text) {
        int[] frequency = buildFrequencyTable(text);
        compression.HuffmanTree huffmanTree = new compression.HuffmanTree();
        root = huffmanTree.buildTree(frequency);
        huffmanCodeMap = new HashMap<>();
        buildHuffmanCodeMap(root, "");
    }

    private int[] buildFrequencyTable(String text) {
        int[] frequency = new int[256];
        for (char ch : text.toCharArray()) {
            frequency[ch]++;
        }
        return frequency;
    }

    private void buildHuffmanCodeMap(compression.Node node, String code) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            huffmanCodeMap.put(node.ch, code);
        }

        buildHuffmanCodeMap(node.left, code + '0');
        buildHuffmanCodeMap(node.right, code + '1');
    }

    public String compress(String text) {
        StringBuilder compressedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            compressedText.append(huffmanCodeMap.get(ch));
        }
        return compressedText.toString();
    }

    public String decompress(String compressedText) {
        StringBuilder decompressedText = new StringBuilder();
        compression.Node current = root;
        for (char bit : compressedText.toCharArray()) {
            current = bit == '0' ? current.left : current.right;

            if (current.left == null && current.right == null) {
                decompressedText.append(current.ch);
                current = root;
            }
        }
        return decompressedText.toString();
    }
}
