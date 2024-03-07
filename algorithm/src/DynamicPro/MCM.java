package DynamicPro;

public class MCM {
	static int solveT(int n,int arr[]){
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int ans=(int)1e9;
                for(int k=i;k<j;k++){
                    ans=Math.min(ans,arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j]);
                }
                dp[i][j]=ans;  
            }
        } 
        return dp[1][n-1];
        
    }
    static int solveM(int i,int j ,int arr[],Integer dp[][]){
        if(i==j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int ans=(int)1e9;
    
        for(int k=i;k<j;k++){
            ans=Math.min(ans,arr[i-1]*arr[k]*arr[j]+solveM(i,k,arr,dp)+solveM(k+1,j,arr,dp));
        }
        return dp[i][j]=ans;
    }
    static int solve(int i,int j,int arr[]){
        if(i==j) return 0;
        int ans=(int)1e9;
        
        for(int k=i;k<j;k++){
            ans=Math.min(ans,arr[i-1]*arr[k]*arr[j]+solve(i,k,arr)+solve(k+1,j,arr));
        }
        return ans;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // // code here
        // Integer dp[][]=new  Integer[N][N];
        // return solveM(1,N-1,arr,dp);
        return solveT(N,arr);
    }

}
