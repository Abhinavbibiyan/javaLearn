package DynamicPro;

public class prtitionArraySum {
	public int solveUtil(int i,int k,int arr[],Integer dp[]){
        if(i==arr.length){
            return 0;
        }
        if(dp[i]!=null) return dp[i];
        int maxAns=Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        int len=0;
        for(int j=i;j<Math.min(i+k,arr.length);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=maxi*len+solveUtil(j+1,k,arr,dp);
            maxAns=Math.max(maxAns,sum);
        }
        return dp[i]=maxAns;
    }
    
    public static int solveT(int n,int k,int arr[]){
        int dp[]=new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int maxAns=Integer.MIN_VALUE;
            int maxi=Integer.MIN_VALUE;
            int len=0;
            for(int j=i;j<Math.min(i+k,arr.length);j++){
                len++;
                maxi=Math.max(maxi,arr[j]);
                int sum=maxi*len+dp[j+1];
                maxAns=Math.max(maxAns,sum);
            }
            dp[i]=maxAns;
        }
        return dp[0];
    }
    
    public static int solve(int N, int k, int arr[]){
        //Code here
        // Integer dp[]=new Integer[N+1];
        // return solveUtil(0,k,arr,dp);
        return solveT(N,k,arr);
    }
    public static void main(String[] args) {
		int arr[] = {1,15,7,9,2,5,10};
		int N=arr.length;
		int k=3;
		
		System.out.println(solve(N,k,arr));
		//arr becomes [15,15,15,9,10,10,10];
	}
}

