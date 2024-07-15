package cogoPort;
import java.util.*;
class quicksort {
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
	public static void sort(int[] arr) {
		int n = arr.length;
		quick(arr, 0, n - 1);
		
	}
	
}


public class KthSmall {
	public static int K_Small(int[] input, int k) {
        if (input == null || input.length < k) {
            System.exit(-1);
        }
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i :input) {
        	p.add(i);
        }
        while (k > 0) {
            p.poll();
            k--;
        }
        return p.peek();
    }
	    public static int kthSmallest(int[] arr, int k) {
	    	quicksort.sort(arr);
	        return arr[k - 1];
	    }
	
    public static void main(String[] args) {
        int[] ip= {7, 4, 6, 3, 9, 1};
        int k = 3;
        System.out.println("Ans is " + kthSmallest(ip, k));
    }
}
