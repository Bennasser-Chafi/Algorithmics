import java.util.List;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }


    public void insert(Node node) {
        root = addRecursive(root, node.key);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (current.key < value) {
            current.right = addRecursive(current.right, value);
        } else if (current.key > value) {
            current.left = addRecursive(current.left, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    public void remove(Node node) {
        root = removeRecursive(root, node);
    }

    public Node removeRecursive(Node current, Node nodeToDelete) {

        if (current == null)
            return current;

        if (current.key > nodeToDelete.key) {
            current.left = removeRecursive(current.left, nodeToDelete);
        } else if (current.key < nodeToDelete.key) {
            current.right = removeRecursive(current.right, nodeToDelete);

        } else {
            if (current.left == null && current.right == null)
                current = null;

            else if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current = current.left;
            } else {
                Node minNode = findMinRecursive(current.right);
                current.key = minNode.key;
                removeRecursive(current.right, minNode);
            }
        }
        return current;
    }


    public Node findMin() {
        return findMinRecursive(root);
    }

    private Node findMinRecursive(Node current) {
        if (current == null) {
            return null;
        }
        if (current != null && current.left == null) {
            return current;
        }
        return findMinRecursive(current.left);
    }


    public Node findMax() {
        return findMaxRecursive(root);
    }

    private Node findMaxRecursive(Node current) {
        if (current == null) {
            return null;
        }
        if (current != null && current.right == null) {
            return current;
        }
        return findMaxRecursive(current.right);
    }

    public static int[] sort(int[] array) {

        int[] sortedArray = new int[array.length];
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            tree.insert(new Node(array[i]));
        }
     //   inOrder(tree.root, sortedArray, 0);

        return sortedArray;
    }

    public static void inOrder(Node current ) {

        if (current != null) {
            inOrder(current.left);

            //Visit the node by Printing the node data

         //   sortedArray[i] =current.key;


            inOrder(current.right);
        }

    }


}
