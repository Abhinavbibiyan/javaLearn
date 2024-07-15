package array;

public class maxProd {
	
	public static int maxProduct(final int[] A) {
		int ans=A[0],i,n=A.length;
		int curMin=1,curMax=1;
		for(i=0;i<n;i++)
		{
		   int temp=curMin;
		   curMin=Math.min(A[i],Math.min(A[i]*curMin,A[i]*curMax));
		   curMax=Math.max(A[i],Math.max(A[i]*curMax,A[i]*temp));
		   ans=Math.max(ans,curMax);
		}
		return ans;
		
		}
	public static void main(String[] args) {
		int[] A= {2, 3, -2, 4 ,8};
		System.out.println(maxProduct(A));
	}
}
