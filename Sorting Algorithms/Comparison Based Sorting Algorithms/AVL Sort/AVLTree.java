import java.util.ArrayList;
import java.util.List;

public class AVLTree {

    // The root of the tree
    Node root;

    public AVLTree() {
    }

    public int height(Node node) {
        if (node == null)
            return -1;

        return node.height;
    }

    // Get Balance factor of a node
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    //  Perform a right rotate operation in a subtree
    public Node rightRotate(Node subTreeRoot) {
        Node newRoot = subTreeRoot.left;

        subTreeRoot.left = newRoot.right;
        newRoot.right = subTreeRoot;

        // Update heights
        subTreeRoot.height = Math.max(height(subTreeRoot.left), height(subTreeRoot.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    // Perform a left rotate operation in a subtree
    public Node leftRotate(Node subTreeRoot) {
        Node newRoot = subTreeRoot.right;

        subTreeRoot.right = newRoot.left;
        newRoot.left = subTreeRoot;

        // Update heights
        subTreeRoot.height = Math.max(height(subTreeRoot.left), height(subTreeRoot.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    public void insert(Node newNode) {
        root = addRecursive(root, newNode.key);
    }

    /**
     * @param current, the root of the current subtree in the recursive method
     * @param value,   the new value to be inserted
     * @return the root of the resulting tree after the new value being added
     * @complexity the complexity of the insertion method is O(log n)
     */
    private Node addRecursive(Node current, int value) {
        // Perform the normal BST insertion
        if (current == null) {
            return new Node(value);
        }
        if (current.key < value) {
            current.right = addRecursive(current.right, value);
        } else if (current.key > value) {
            current.left = addRecursive(current.left, value);
        } else {
            return current;
        }

        current.height = 1 + Math.max(height(current.left), height(current.right));
        // Fix AVL property

        /// LL rotation
        if (getBalance(current) > 1 && value < current.left.key)
            return rightRotate(current);
        // RR rotation
        if (getBalance(current) < -1 && value > current.right.key)
            return leftRotate(current);
        // LR
        if (getBalance(current) > 1 && value > current.left.key) {
            current.left = leftRotate(current.left);
            return rightRotate(current);
        }
        // RL
        if (getBalance(current) < -1 && value < current.right.key) {
            current.right = rightRotate(current.right);
            return leftRotate(current);
        }
        return current;
    }

    public static Integer[] sort(int[] array) {
        List<Integer> sortedList = new ArrayList<>();
        AVLTree tree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            tree.insert(new Node(array[i]));
        }
        inOrder(tree.root, sortedList);
        return sortedList.toArray(new Integer[sortedList.size()]);
    }

    public static void inOrder(Node current, List<Integer> sortedList) {
        if (current != null) {
            inOrder(current.left, sortedList);
            sortedList.add(current.key);
            inOrder(current.right, sortedList);
        }
    }

    public void postOrderTraversal(Node node){
       if(node != null){
           postOrderTraversal(node.left);
           postOrderTraversal(node.right);
           System.out.print(" " +node.key);
       }
    }

}
