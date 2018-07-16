import java.util.Arrays;
import java.util.Random;

/**
 * @author CHAFI Bennassar
 * @context This project illustrate an implementation of the BST data structure, and the BST Sort algorithm.
 */

public class Main {

    public static void main(String[] args) {

        int array[] = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((100 - 0) + 1);
        }

        long start = System.nanoTime();
        Integer[] sortedArray = BinarySearchTree.sort(array);
        long time = System.nanoTime() - start;

        System.out.println("Time required to sort this array using BST Sort Algorithm is : "
                + (time / 100000 / 1000.0) + " seconds!");
        System.out.println(Arrays.toString(sortedArray));

        System.out.println("*************************************");

        //  create a BST DS
        BinarySearchTree tree = new BinarySearchTree();
        Node root = new Node(5);
        Node node1 = new Node(2);
        Node node2 = new Node(12);
        Node node3 = new Node(-4);
        Node node4 = new Node(3);
        Node node5 = new Node(9);
        Node node6 = new Node(21);
        Node node7 = new Node(19);
        Node node8 = new Node(25);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node6.left = node7;
        node6.right = node8;
        tree.root = root;

        // return max (keep going to the right)
        System.out.println(tree.findMax().key);

        // return min (keep going to the left)
        System.out.println(tree.findMin().key);

        //insert element
        tree.insert(new Node(17));

        // remove an element
        tree.remove(new Node(25));
    }
}