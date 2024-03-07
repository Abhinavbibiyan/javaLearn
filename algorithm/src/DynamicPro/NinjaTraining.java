package DynamicPro;
import java.util.*;
public class NinjaTraining {
	public static int solve(int day,int task,int[][] points,int[][]dp){

        if(day==0){
            if(dp[0][task]!=-1) return  dp[0][task];
            int ans=0;
            for(int i=0;i<3;i++){
                if(i!=task){
                    ans=Math.max(ans,points[0][i]);
                }
            } 
        return ans;    
        }
        if(dp[day][task]!=-1) return dp[day][task];
        int ans=0;
        for(int last=0;last<3;last++){
            if(last!=task){
                ans=Math.max(solve(day-1,last,points,dp)+points[day][last],ans);
            }
        }    
        return dp[day][task]=ans;    
        }
	 public static int solve1(int n,int[][]points){
         int[][]dp=new int[n][4];
         dp[0][0]=Math.max(points[0][1],points[0][2]);
         dp[0][1]=Math.max(points[0][0],points[0][2]);
         dp[0][2]=Math.max(points[0][1],points[0][0]);
         dp[0][3]=Math.max(Math.max(points[0][1],points[0][2]),points[0][0]);

         for(int day=1;day<n;day++){
             for(int last=0;last<4;last++){
                 dp[day][last]=0;
                 for(int task=0;task<3;task++){
                     if(task!=last){
                         dp[day][last]=Math.max(dp[day-1][task]+points[day][task],dp[day][last]);
                     }
                 }
             }
         }
         return dp[n-1][3];
     }
    
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int dp[][]=new int[n+1][4];
        // Arrays.fill(dp,-1);
        for(int i=0;i<=n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n-1,3,points,dp);
    }
    public static void main(String[] args) {
		int n=3;
		int [][]points= {{
				10 ,40 ,70},{
				20 ,50 ,80},{
				30 ,60 ,90}};
		System.out.println(ninjaTraining(n,points));
		System.out.println(solve1(n,points));
	}
}
