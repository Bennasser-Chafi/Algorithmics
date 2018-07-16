/**
 * @author CHAFI Bennassar
 *
 * @context This project illustrate an implementation of the Heap data structure, and the Heap Sort algorithm.
 */

public class Main {

    public static void main(String[] args) {

        Node[] array = new Node[7];
        array[0] = new Node(2);
        array[1] = new Node(9);
        array[2] = new Node(3);
        array[3] = new Node(5);
        array[4] = new Node(4);
        array[5] = new Node(7);
        array[6] = new Node(2);

        Heap heap = new Heap(array);
        // Display the Heap
        System.out.print("Display Heap");
        heap.displayHeap();

        System.out.println("*****************");
        Heap maxHeap = Heap.buildMaxHeap(array);
        // Display the Max-Heap
        System.out.println("Display Max Heap");
        maxHeap.displayHeap();

        // Sort the array using Heap Sort algorithm
        Node[] sortedArray = Heap.sort(array);
        System.out.println("*****************");
        System.out.println("Display Sorted Array using Heap Sort Algorithm");
        for (int i = 0; i < sortedArray.length; i++) {
           System.out.print(sortedArray[i].getKey()+ "  ");
        }
    }
}
