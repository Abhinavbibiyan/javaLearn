package array;

public class insertionSort {
	public static void main(String[] args) {
		int[] a = { 3, 9, 4, 8, 2, 5, 1 };
		int n = a.length;
		for (int i = 1; i <= n - 1; i++) {
			int unsort = a[i];
			int j = i - 1;
			while (j >= 0 && unsort < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = unsort;
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
