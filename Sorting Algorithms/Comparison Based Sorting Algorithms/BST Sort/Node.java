/**
 * This class represents a single node in the Binary Search Tree data structure(BST)
 */

public class Node {

    int key;
    // left child node
    Node left;
    // right child node
    Node right;
    // number of duplicates
    int count;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        count = 1;
    }
}
