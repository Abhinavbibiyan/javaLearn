package DynamicPro;
import java.util.*;
public class burstBalloon {
	int solve(ArrayList<Integer>arr,int i,int j){
        if(i>j) return 0;
        
        int maxi=Integer.MIN_VALUE;
        
        for(int index=i;index<=j;index++){
            int ans=arr.get(i-1)*arr.get(index)*arr.get(j+1)+solve(arr,i,index-1)+solve(arr,index+1,j);
            maxi=Math.max(ans,maxi);
        }
        return maxi;
        
    }
    int solveM(ArrayList<Integer>arr,int i,int j,Integer dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        
        for(int index=i;index<=j;index++){
            int ans=arr.get(i-1)*arr.get(index)*arr.get(j+1)+solveM(arr,i,index-1,dp)+solveM(arr,index+1,j,dp);
            maxi=Math.max(ans,maxi);
        }
        return dp[i][j]=maxi;
        
    }
    int solveT(ArrayList<Integer>arr,int N){
        int dp[][]=new int[N+2][N+2];
        
        for(int i=N;i>=1;i--){
            for(int j=1;j<=N;j++){
                if(i>j) continue;
                int maxi=Integer.MIN_VALUE;
                for(int index=i;index<=j;index++){
                    int ans=arr.get(i-1)*arr.get(index)*arr.get(j+1)+dp[i][index-1]+dp[index+1][j];
                    maxi=Math.max(ans,maxi);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][N];
    }
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
// 		Integer dp[][]=new Integer[N+1][N+1];
		arr.add(0,1);
		arr.add(arr.size(),1);
// 		return solveM(arr,1,N,dp);
        return solveT(arr,N);
	}
}
