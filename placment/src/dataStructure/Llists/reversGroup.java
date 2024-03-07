package dataStructure.Llists;

import java.util.ArrayList;
import java.util.Collections;

public class reversGroup {
	void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		for (int i = 0; i < n; i = i + k) {
			int start = i;
			int end = Math.min(i + k - 1, n - 1);
			while (start < end) {
				Collections.swap(arr, start, end);
				start++;
				end--;
			       			}
		}
	}
	public static void main(String[] args) {
		
	}
}
