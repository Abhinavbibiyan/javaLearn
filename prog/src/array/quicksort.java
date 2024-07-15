package array;
public class quicksort {
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		return i;
	}
	public static void quick(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quick(arr, low, pi - 1);
			quick(arr, pi + 1, high);
		}
	}
	public static void main(String[] args) {
		int arr[] = { 7, 3, 8, 2, 63, 5,37,10 };
		int n = arr.length;
		quick(arr, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] +" , ");
		}
	}
}
