package array;

public class mergSort {
	public static void conqure(int arr[], int si, int ei, int mid) {
		int merge[] = new int[ei - si + 1];
		int index1 = si;
		int index2 = mid + 1;
		int x = 0;
		while (index1 <= mid && index2 <= ei) {
			if (arr[index1] <= arr[index2]) {
				merge[x++] = arr[index1++];

			} else {
				merge[x++] = arr[index2++];
			}
		}
		while (index1 <= mid) {
			merge[x++] = arr[index1++];
		}
		while (index2 <= ei) {
			merge[x++] = arr[index2++];
		}
		for (int i = 0, j = si; i < merge.length; i++, j++) {
			arr[j] = merge[i];
		}
	}

	public static void divide(int arr[], int si, int ei) {
		if (si >= ei) {
			return;
		}
		int mid = si + (ei - si) / 2;
		divide(arr, si, mid);
		divide(arr, mid + 1, ei);
		conqure(arr, si, ei, mid);
	}

	public static void main(String[] args) {
		int[] a = { 5, 16, 3, 32, 45, 74, 15, 14 };
		int n = a.length;
		divide(a, 0, n - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
}
