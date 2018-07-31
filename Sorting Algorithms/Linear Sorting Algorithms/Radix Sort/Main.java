import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] argv) {
        int array[] = new int[100];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }

        long start = System.nanoTime();
        int[] sortedArray = sortUsingRadixSort(array);
        long time = System.nanoTime() - start;

        System.out.println("Time required to sort this array using Radix Sort Algorithm is : "
                + (time / 100000 / 1000.0) + " seconds!");
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sortUsingRadixSort(int[] array) {

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            max = (array[i] > max) ? array[i] : max;
        }
        int maxExp = (int) (Math.log(max) / Math.log(10));

        for (int i = 0; i <= maxExp; i++) {
            array = sortUsingCountingSort(array, (int) Math.pow(10, i));
        }
        return array;
    }

    public static int[] sortUsingCountingSort(int[] array, int exp) {
        int[] counts = new int[10];
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            counts[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[counts[(array[i] / exp) % 10] - 1] = array[i];
            counts[(array[i] / exp) % 10]--;
        }
        return sortedArray;
    }
}
