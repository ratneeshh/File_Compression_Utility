package compression;

public class Node {
    int frequency;
    char character;
    Node left, right;

    public Node(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
        this.left = this.right = null;
    }

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
