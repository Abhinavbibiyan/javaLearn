package array;

import java.util.Arrays;

public class threeSum {

	public static void main(String[] args) {
		int[] a= {4,5,3,6,8,7,9,2};
		int n=a.length;
		boolean found=false;
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int sum=24;
		for(int i=0;i<n;i++) {
			int lo=i+1;
			int hi=n-1; 
			while(lo<hi) { 
				int total=a[i]+a[lo]+a[hi];
				if(total==sum) {
					found= true;
					System.out.println(a[i]+" + "+ a[lo]+" + "+ a[hi]);
					 
				}
				if(total<sum) { 
					lo++;
				}
				else hi--;
				
			}
			if(found) break;
		}
	}
}
