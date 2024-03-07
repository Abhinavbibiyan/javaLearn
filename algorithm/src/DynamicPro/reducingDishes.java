package DynamicPro;
import java.util.*;
public class reducingDishes {
	public int solve(int[] satisfaction,int index,int time,Integer dp[][]){
        if(index==satisfaction.length){
            return 0;
        }
        if(dp[index][time]!=null) return dp[index][time];
        int include=satisfaction[index]*(time+1)+solve(satisfaction,index+1,time+1,dp);
        int exclude=solve(satisfaction,index+1,time,dp);
        return dp[index][time]=Math.max(include,exclude);
    }
    public int solveTab(int[] satisfaction){
        int n=satisfaction.length;
        int dp[][]=new int[n+1][n+1];
        for(int index=n-1;index>=0;index--){
            for(int time=n-1;time>=0;time--){
                int include=satisfaction[index]*(time+1)+dp[index+1][time+1];
                int exclude=dp[index+1][time];
                dp[index][time]=Math.max(include,exclude);
            }
        }
        return dp[0][0];
    }
    public int solveS(int[] satisfaction){
        int n=satisfaction.length;
        int next[] =new int[n+1];
        int curr[] =new int[n+1];
        for(int index=n-1;index>=0;index--){
            for(int time=n-1;time>=0;time--){
                int include=satisfaction[index]*(time+1)+next[time+1];
                int exclude=next[time];
                curr[time]=Math.max(include,exclude);
                next=curr;
            }
        }
        return next[0];
    }
    public int maxSatisfaction(int[] satisfaction) {
        // int n=satisfaction.length;
        // Integer dp[][]=new Integer[n+1][n+1];
        Arrays.sort(satisfaction);
        // return solve(satisfaction,0,0,dp);
        // return solveTab(satisfaction);
        int prefSum = 0, res = 0, n = satisfaction.length;
        for (int i = n - 1; i >= 0; i--) {
            prefSum += satisfaction[i];
            if (prefSum < 0) {
                break;
            }
            res += prefSum;
        }
        
        return res;
    }

}
