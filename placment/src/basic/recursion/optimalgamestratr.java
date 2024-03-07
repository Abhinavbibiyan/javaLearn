package basic.recursion;

public class optimalgamestratr {
	static int solve(int[] arr,int i,int j) {
		if(i>j) {
			return 0;
		}
		int c1=arr[i]+Math.min(solve(arr,i+2,j),solve(arr,i+1,j-1));
		int c2=arr[j]+Math.min(solve(arr,i,j-2),solve(arr,i+1,j-1));
		int ans=Math.max(c1,c2);
		return ans;
	}
public static void main(String[] args) {
	int[] arr= {20,30,2,2,2,10};
	int i=0;
	int j=5;
	System.out.println("ans is " +solve(arr,i,j));
}
}
