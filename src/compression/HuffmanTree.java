package compression;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {

    private static Map<Character, String> codes = new HashMap<>();
    private static Map<String, Character> reverseCodes = new HashMap<>();

    public static compression.Node buildTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<compression.Node> priorityQueue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new compression.Node(entry.getValue(), entry.getKey()));
        }

        while (priorityQueue.size() > 1) {
            compression.Node left = priorityQueue.poll();
            compression.Node right = priorityQueue.poll();
            compression.Node parent = new compression.Node(left.frequency + right.frequency, left, right);
            priorityQueue.add(parent);
        }

        return priorityQueue.poll();
    }

    public static void buildCodes(compression.Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            codes.put(root.character, code);
            reverseCodes.put(code, root.character);
        }
        buildCodes(root.left, code + '0');
        buildCodes(root.right, code + '1');
    }

    public static String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encoded.append(codes.get(ch));
        }
        return encoded.toString();
    }

    public static String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char bit : encoded.toCharArray()) {
            temp.append(bit);
            if (reverseCodes.containsKey(temp.toString())) {
                decoded.append(reverseCodes.get(temp.toString()));
                temp.setLength(0);
            }
        }
        return decoded.toString();
    }
}
