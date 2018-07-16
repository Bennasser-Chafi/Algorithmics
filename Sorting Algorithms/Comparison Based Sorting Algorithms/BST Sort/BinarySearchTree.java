import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the BST data structure and the BST Sort algorithm
 */

public class BinarySearchTree {

    // root of the BST
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Node node) {
        root = addRecursive(root, node.key);
    }

    /**
     * @param current, the root of the current subtree in the recursive method
     * @param value, the new value to be inserted
     * @return the root of the resulting tree after the new value being added
     * @complexity the complexity of the insertion method is O(h) where h is the height of the tree
     */
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (current.key < value) {
            current.right = addRecursive(current.right, value);
        } else if (current.key > value) {
            current.left = addRecursive(current.left, value);
        } else {
            current.count++;
            return current;
        }
        return current;
    }

    public void remove(Node node) {
        root = removeRecursive(root, node);
    }

    /**
     * @param current, the root of the current subtree in the recursive method
     * @param nodeToDelete, the node to be deleted
     * @return the root of the resulting tree after the node being removed
     * @complexity the complexity of the remove method is O(h) where h is the height of the tree
     */
    public Node removeRecursive(Node current, Node nodeToDelete) {

        if (current == null)
            return current;

        if (current.key > nodeToDelete.key) {
            current.left = removeRecursive(current.left, nodeToDelete);
        } else if (current.key < nodeToDelete.key) {
            current.right = removeRecursive(current.right, nodeToDelete);

        } else {
            if (current.count > 1) {
                (current.count)--;
                return root;
            }
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

    /**
     * @return the node with the minimum value (keep going left)
     */
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

    /**
     * @return the node with the maximum value (keep going right)
     */
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

    /**
     * @param array to be sorted
     * @return the sorted array using BST Sort algorithm
     * @complexity the complexity of the BST Sort algorithm is n*log(n)
     */
    public static Integer[] sort(int[] array) {
        List<Integer> sortedList = new ArrayList<>();
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            tree.insert(new Node(array[i]));
        }
        inOrder(tree.root, sortedList);
        return sortedList.toArray(new Integer[sortedList.size()]);
    }

    /**
     * @context this method implements the Inorder Traversal algorithm to get the sorted array from the BST DS
     * @param current, root of the current subtree in the recursive method
     * @param sortedList, the sorted listed
     */
    public static void inOrder(Node current, List<Integer> sortedList) {
        if (current != null) {
            inOrder(current.left, sortedList);
            for (int i = 0; i < current.count; i++) {
                sortedList.add(current.key);
            }
            inOrder(current.right, sortedList);
        }
    }
}