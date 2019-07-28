package sorting.quickSort;

public class QuickSort {
	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot-1 );
			quickSort(array, pivot + 1,end);
		}
	}

	
	static int partition(int[] array, int start, int end) {
		// start is equivalent to j
		int pivot = end;
		int i = start-1;
		for (int j = start; j <= end; j++) {
			if (array[j] <= array[pivot]) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		return i;

	}
	
	
	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}
	
}