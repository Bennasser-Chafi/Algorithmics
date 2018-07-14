import java.util.Arrays;
import java.util.Random;

/**
 * @author CHAFI Bennassar
 *
 * @context : This class implements the Binary Insertion Sort algorithm, which
 *          is a sort of enhancement of the Insertion Sort algorithm. It uses
 *          the binary search instead of pairwise swaps to find the right
 *          position of an element which reduces the complexity of this
 *          algorithm from n^2 to n*log(n) in terms of compares.
 */

public class Main {

	public static void main(String[] args) {

		int array[] = new int[100];
		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt((100 - 0) + 1) + 0;
		}

		long start = System.nanoTime();
		int[] sortedArray = sortUsingBinaryInsertionSort(array);
		long time = System.nanoTime() - start;

		System.out.println("Time required to sort this array using Binary Insertion Sort algorithm is : "
				+ (time / 100000 / 1000.0) + " seconds!");
		System.out.println(Arrays.toString(sortedArray));
	}

	/**
	 * @context This method implements the Binary Insertion Sort algorithm
	 * @complexity The worst-case complexity of this algorithm is n*log(n) in terms of compares and n^2 in terms of swaps 
	 * @param array, array to be sorted
	 * @return the sorted array using Binary Insertion Sort algorithm
	 */
	public static int[] sortUsingBinaryInsertionSort(int[] array) {

		int[] sortedArray = array;

		for (int i = 1; i < sortedArray.length; i++) {

			int rightIndex = getRightPosition(sortedArray, 0, i - 1, array[i]);

			for (int j = i; j > rightIndex; j--) {
				int temp = sortedArray[j];
				sortedArray[j] = sortedArray[j - 1];
				sortedArray[j - 1] = temp;
			}
		}
		return sortedArray;
	}

	/**
	 * @context This Method implements the Binary Search Algorithm to find the
	 *          right index where a new element fits to maintain an array
	 *          sorted. This algorithm has a complexity of log(n).
	 *
	 * @param sortedArray, a sorted array to search within
	 * @param fromIndex, the index from which we start the search (inclusive)
	 * @param toIndex, the index of the last element (inclusive) to be searched
	 * @param newElement, element to find the position where it fits in the sorted array
	 *           
	 * @return position where the new element fits
	 **/
	public static int getRightPosition(int[] sortedArray, int fromIndex, int toIndex, int newElement) {

		if (sortedArray == null) {
			return -1;
		}

		if (fromIndex > toIndex) {
			return fromIndex;
		}

		int midleIndex = (toIndex + fromIndex) / 2;

		if (newElement < sortedArray[midleIndex]) {
			return getRightPosition(sortedArray, fromIndex, midleIndex - 1, newElement);

		} else if (newElement > sortedArray[midleIndex]) {
			return getRightPosition(sortedArray, midleIndex + 1, toIndex, newElement);
		}
		return midleIndex;
	}
}
