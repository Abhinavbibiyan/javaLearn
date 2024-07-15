package array;

import java.util.*;

public class maxDayTrip {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < m; i++)
			arr[i] = sc.nextInt();
		int ans = 0;
		for(int e:arr) {
			System.out.print(e +" ");
		} 
		
		System.out.println();
		
		Arrays.sort(arr);//*2 3 ** 6 7*9*
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" "); 
		}
		System.out.println("\n"+arr[3]);
		if (k > 0) {
			for (int i = k + 1; i <= m + 2; i++) {//3--7
				System.out.println("arr["+i+"] = " + arr[i] +" arr["+i +"-"+ k+"-"+" 1] = "+ arr[i - k - 1]);
				ans = Math.max(ans, arr[i] - arr[i - k - 1] - 1);
				System.out.println(ans);
			} 
		} else { 
			int j = 0;  
			while (arr[j] == 0)  
				j++;
			int count = 0;
			for (int i = 1; i <= n; i++) {
				count++;
				if (j < n && (i == arr[j])) { 
					count = 0; 
					j++;
				} 
				ans = Math.max(count, ans);
			}
		}
		System.out.println(ans);
	}
}
