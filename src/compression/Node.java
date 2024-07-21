package compression;

public class Node implements Comparable<Node> {
    public char ch;
    public int frequency;
    public Node left;
    public Node right;

    public Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}
