package algorithm;

public class kendasAlgo {
	
	static int maxSum(int[] arr) {
		int n=arr.length;
		int curSum=0;
		int maxSum=arr[0];
		for(int i=0;i<n;i++) {
			curSum+=arr[i];
			maxSum=Math.max(maxSum, curSum);
			if(curSum<0) curSum=0;
			
			
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int[] arr= {5,4,-1,7,8};			//1,6-2,4,3,-5,4,1,-2,5
											// -2,1,-3,4,-1,2,1,-5,4
		System.out.println(maxSum(arr));
	}
}
