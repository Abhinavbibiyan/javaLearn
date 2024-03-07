package DynamicPro;

public class absDiffrenceSubset {
	public static int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int e:arr) sum+=e;
	    int[][] dp=new int[n][sum+1];
	    
	    for(int i=0;i<n;i++){
	        dp[i][0]=1;
	    }
	    if(arr[0]<=sum) dp[0][arr[0]]=1;
	    for(int index=1;index<n;index++){
	        
	        for(int target=1;target<=sum;target++){
	            int take=0;
	            if(arr[index]<=target){
	                //take
	                take=dp[index-1][target-arr[index]];
	            }
	            int nottake=dp[index-1][target];
	            dp[index][target]=take | nottake ;
	        }
	    }
	    
	    int mini=(int)1e8;
	    
	    for(int i=0;i<=sum/2;i++){
	        if(dp[n-1][i]==1){
	            mini=Math.min(mini,Math.abs((sum-i)-i));
	        }
	        
	    }
	    return mini;
	    
	} 
	public static void main(String[] args) {
		
		int n=5;
		int[]arr={20 ,19 ,18 ,20 ,16};
		System.out.println(minDifference(arr,n));
	}
}
