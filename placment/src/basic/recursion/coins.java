package basic.recursion;

public class coins {
	public static int solve(int[] arr,int siz,int s,int curr) {
		 int ways = 0 ;
		 if(s==0) {
			 return 1;
		 }
		 if(s<0) {
			 return 0;
		 }
		for(int i=curr;i<siz;i++)
		{		 ways+=solve(arr, siz,s-arr[i],i);
		}
		return ways;
	}
public static void main(String[] args) {
	int[] coins= {1,2};
	int size=coins.length;
	int sum=4;
	int way=solve(coins,size,sum,0);
	System.out.println(way);
}
}
