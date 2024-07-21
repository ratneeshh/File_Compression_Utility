package compression;

import java.util.PriorityQueue;

public class HuffmanTree {
    public compression.Node buildTree(int[] frequency) {
        PriorityQueue<compression.Node> pq = new PriorityQueue<>();
        for (char i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                pq.add(new compression.Node(i, frequency[i]));
            }
        }

        while (pq.size() > 1) {
            compression.Node left = pq.poll();
            compression.Node right = pq.poll();
            compression.Node parent = new compression.Node(left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        return pq.poll();
    }
}
