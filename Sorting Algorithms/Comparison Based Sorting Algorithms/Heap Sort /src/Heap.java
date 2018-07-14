import java.util.Arrays;

/**
 * This class implements the heap data structure and the Heap Sort algorithm
 */

class Heap {

    private Node[] heapArray;
    private int heapSize;

    public Heap(Node[] array) {
        heapArray = array;
        heapSize = array.length;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * @param maxHeap, heap which maintains the Max-heap property
     * @return the maximum element in the Max-heap which corresponds to the node at index 0
     */
    public static Node returnMaxNode(Heap maxHeap) {
        return (maxHeap.isEmpty()) ? null : maxHeap.heapArray[0];
    }

    /**
     * @param heap
     * @return true if it is a Max-heap otherwise return false
     */
    public static boolean isMaxHeap(Heap heap) {
        for (int i = 0; i < (heap.heapSize / 2); i++) {
            if (heap.heapArray[i].getKey() < heap.heapArray[2 * i + 1].getKey() || heap.heapArray[i].getKey() < heap.heapArray[2 * i + 2].getKey()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @context this method is used to correct a single violation of the max-heap property in a subtree's root indexed by
     * index
     *
     * @param array
     * @param index, the root of the subtree where the violation of the max-heap property might occur
     * @return the heap after correcting the violation
     */
    public static Node[] maxHeapify(Node[] array, int index) {

        if ((array == null || index < 0 || index >= (array.length / 2)) || ((((2 * index + 2) >= array.length) && array[index].getKey() >= array[2 * index + 1].getKey()) || ((2 * index + 2) < array.length && array[index].getKey() >= array[2 * index + 1].getKey() && array[index].getKey() >= array[2 * index + 2].getKey())))
            return array;

        int indexOfLargestkey = 0;
        if ((2 * index + 2) < array.length)
            indexOfLargestkey = (array[2 * index + 1].getKey() > array[2 * index + 2].getKey()) ? (2 * index + 1) : (2 * index + 2);
        else
            indexOfLargestkey = 2 * index + 1;

        int temp = array[index].getKey();
        array[index].setKey(array[indexOfLargestkey].getKey());
        array[indexOfLargestkey].setKey(temp);
        return maxHeapify(array, indexOfLargestkey);
    }

    /**
     * @context This method produces a Max-heap from an unordered array
     * @param array
     * @return the Max-heap associated with the array
     */
    public static Heap buildMaxHeap(Node[] array) {
        Node[] maxheapAsArray = new Node[array.length];
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxheapAsArray = maxHeapify(array, i);
        }
        return new Heap(maxheapAsArray);
    }

    /**
     * @context this method implements the Heap Sort algorithm.
     * @complexity The worst-case complexity of this algorithm is n*log(n)
     * @param array
     * @return the sorted array using Heap Sort algorithm
     */
    public static Node[] sort(Node[] array) {

        Heap maxHeap = buildMaxHeap(array);
        Node[] sortedArray = new Node[array.length];

        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = new Node(returnMaxNode(maxHeap).getKey());

            int tempval = array[0].getKey();
            array[0].setKey(array[array.length - 1].getKey());
            array[array.length - 1].setKey(tempval);

            array = Arrays.copyOf(array, array.length - 1);
            array = maxHeapify(array, 0);
        }
        return sortedArray;
    }

    /**
     * Draw and display a heap in its tree form 
     */
    public void displayHeap() {

        int numberOfLevels = (int) (Math.ceil(Math.log(heapSize + 1) / Math.log(2)));
        int nodePosition = (int) Math.pow(2, numberOfLevels) + 1;

        for (int i = 0; i < heapSize; i++) {
            double temp = Math.log(i + 1) / Math.log(2);

            if ((int) temp == temp) {
                nodePosition /= 2;
                System.out.println("");
                System.out.format("%" + (nodePosition) + "s", "");
                System.out.print(heapArray[i].getKey());

            } else {
                System.out.format("%" + (nodePosition * 2 - 1) + "s", "");
                System.out.print(heapArray[i].getKey());
            }
        }
        System.out.println("");
    }
}