package DynamicPro;
import java.util.*;
public class rodSegment {
	  public int solve(int n,int x,int y,int z,int dp[]){
		    if(n==0) return 0;
		    if(n<0) return Integer.MIN_VALUE;
		    if(dp[n]!=-1) return dp[n];
		    int X= solve(n-x,x,y,z,dp)+1;
		    int Y= solve(n-y,x,y,z,dp)+1;
		    int Z= solve(n-z,x,y,z,dp)+1;
		    
		    return dp[n]=Math.max(X,Math.max(Y,Z));
		}   
		    public int solve1(int n,int x,int y,int z){
		        int []dp=new int[n+1];
		        Arrays.fill(dp,-1);
		        dp[0]=0;
		        for(int i=1;i<=n;i++){
		            if((i-x)>=0){
		                if(dp[i-x]!=-1)
		                    dp[i]=Math.max(dp[i],dp[i-x]+1);
		                
		            }
		            if((i-y)>=0 ){
		                if(dp[i-y]!=-1 )
		                    dp[i]=Math.max(dp[i],dp[i-y]+1);
		            }
		            if((i-z)>=0){
		                if(dp[i-z]!=-1)
		                    dp[i]=Math.max(dp[i],dp[i-z]+1);
		                
		            }
		            // dp[i]=Math.max(X,Math.max(Y,Z));
		        }
		        if(dp[n]<0) 
		            return 0;
		        else
		            return dp[n];
		    }
		    //Function to find the maximum number of cuts.
		    public int maximizeCuts(int n, int x, int y, int z)
		    {
		       //Your code here
		    //   int dp[]=new int[n+1];
		    //   Arrays.fill(dp,-1);
		    //   int ans=solve(n,x,y,z,dp);
		    //   if(ans<-2)
		    //         return 0;
		    //     return ans;     
		    return solve1(n,x,y,z);
		    }	  
		    
}
