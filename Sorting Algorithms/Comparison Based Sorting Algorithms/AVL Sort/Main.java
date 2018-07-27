import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int array[] = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000);
        }

        long start = System.nanoTime();
        Integer[] sortedArray = AVLTree.sort(array);
        long time = System.nanoTime() - start;

        System.out.println("Time required to sort this array using AVL Sort Algorithm is : "
                + (time / 100000 / 1000.0) + " seconds!");
        System.out.println(Arrays.toString(sortedArray));

        System.out.println("*************************************");

        //  create an AVL Tree
        AVLTree tree = new AVLTree();

        Node root = new Node(5);
        tree.root = root;

        // Insert  new nodes in the AVL Tree and maintain the AVL property
        tree.insert(new Node(7));
        tree.insert(new Node(9));

        tree.postOrderTraversal(tree.root);

    }
}
