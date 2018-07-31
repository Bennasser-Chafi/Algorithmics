import java.util.Arrays;
import java.util.Random;

/**
 * @author CHAFI Bennassar
 * @context This class implements the Counting Sort algorithm which is a sorting algorithm that uses the power
 * of the RAM to get an array sorted in linear time.
 *
 */

public class Main {

    public static void main(String argv[]) {

        int array[] = new int[100];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        long start = System.nanoTime();
        int[] sortedArray = sortUsingCountingSort(array);
        long time = System.nanoTime() - start;

        System.out.println("Time required to sort this array using Counting Sort Algorithm is : "
                + (time / 100000 / 1000.0) + " seconds!");
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * @context This algorithm implements the counting sort algorithm
     * @complexity the worst case complexity of this algorithm is order (n + k) where n is the size of the problem
     * and k is the range where fit all the values.
     * @param array to be sorted
     * @return sorted array
     */
    public static int[] sortUsingCountingSort(int[] array) {

        // Find Max
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            max = (array[i] > max) ? array[i] : max;
        }

        int[] counts = new int[max + 1];
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = 0; i < array.length; i++) {

            sortedArray[counts[array[i]] - 1] = array[i];
            counts[array[i]]--;
        }
        return sortedArray;
    }
}


