import java.util.Arrays;
import java.util.Random;

/**
 * @author CHAFI Bennassar
 * @context This class implements the Insertion Sort algorithm, which is a sorting algorithm with a complexity of n^2
 */

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[1000];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((999 - 0) + 1) + 0;
        }

        long start = System.nanoTime();

        Integer[] sortedArray = sortUsingInsertionSort(array);
        long time = System.nanoTime() - start;

        System.out.println("Time required to sort this array using Insertion Sort algorithm is : " + (time / 100000 / 1000.0) + " seconds!");
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * @param array to be sorted using Insertion Sort algorithm
     * @return the sorted array
     */
    public static Integer[] sortUsingInsertionSort(Integer[] array) {

        Integer [] sortedArray = array;

        for (int i = 1; i < sortedArray.length; i++) {
            int indexOfNewElementToSort = i;
            for (int j = i - 1; j >= 0; j--) {
                if (sortedArray[indexOfNewElementToSort] < sortedArray[j]) {
                    int temp = sortedArray[indexOfNewElementToSort];
                    sortedArray[indexOfNewElementToSort] = sortedArray[j];
                    sortedArray[j] = temp;
                    indexOfNewElementToSort = j;
                } else {
                    break;
                }
            }
        }
        return sortedArray;
    }
}
