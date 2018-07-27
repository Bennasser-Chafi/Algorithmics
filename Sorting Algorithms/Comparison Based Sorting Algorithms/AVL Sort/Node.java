/**
 * This class represents a single node in the AVL data structure
 */

public class Node {

    // value stored in this node
    int key;
    // Left child
    Node left;
    // Right child
    Node right;
    // The height of that node which is the length of the longest path from that node to some leaf
    int height;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
        height = 0;
    }
}