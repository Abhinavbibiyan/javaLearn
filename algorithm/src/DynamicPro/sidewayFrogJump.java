package DynamicPro;
import java.util.*;
public class sidewayFrogJump {
	public static int solve(int[] obstacles,int curPos,int curLane){
        int n=obstacles.length;
        if(curPos==n-1) return 0;

        if(obstacles[curPos+1]!=curLane){
            return solve(obstacles,curPos+1,curLane);
        }else{
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(obstacles[curPos]!=i && curLane!=i){
                    ans=Math.min(ans,1+solve(obstacles,curPos,i));
                }
            }
            return ans;
        }  
    }
        public static int solveMem(int[] obstacles,int curPos,int curLane,Integer[][] dp){
        int n=obstacles.length;
        if(curPos==n-1) return 0;
        if(dp[curPos][curLane]!=null) return dp[curPos][curLane];
        if(obstacles[curPos+1]!=curLane){
            return dp[curPos][curLane]= solveMem(obstacles,curPos+1,curLane,dp);
        }else{
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(obstacles[curPos]!=i && curLane!=i){
                    ans=Math.min(ans,1+solveMem(obstacles,curPos,i,dp));
                }
            }
            return dp[curPos][curLane]= ans;
        }  
    }
        public static int solveTab(int[]obstacles){
            int n=obstacles.length;
            int[][] dp=new int[n+1][4];
            for(int[] row : dp){
                 Arrays.fill(row,(int)1e9);
            } 
            dp[n-1][0]=0;
            dp[n-1][1]=0;
            dp[n-1][2]=0;
            dp[n-1][3]=0;
            for(int curPos=n-2;curPos>=0;curPos--){
                for(int curLane=1;curLane<=3;curLane++){
                    if(obstacles[curPos+1]!=curLane){
                        dp[curPos][curLane]= dp[curPos+1][curLane];
                    }else{
                        // int ans=Integer.MAX_VALUE;
                        int ans=(int)1e9;
                        for(int i=1;i<=3;i++){
                            if(obstacles[curPos]!=i && curLane!=i){
                                ans=Math.min(ans,1+dp[curPos+1][i]);
                            }
                        }
                        dp[curPos][curLane]=ans;
                    }    
                }
            }
            return Math.min(Math.min(dp[0][1]+1,dp[0][3]+1),dp[0][2]);
        }
    public static int minSideJumps(int[] obstacles) {
        int n=obstacles.length;
//        Integer[][] dp=new Integer[n+1][4];
//        return solveMem(obstacles,0,2,dp);
//          return solve(obstacles,0,2);
        return solveTab(obstacles);
    }
    public static void main(String[] args) {
    	int[] obstacles= {0,2,2,1,0,3,0,3,0,1,3,1,1,0,1,3,1,1,1,0,2,0,0,3,3,0,3,2,2,0,0,3,3,3,0,0,2,0,0,3,3,0,3,3,
    					  0,0,3,1,0,1,0,2,3,1,1,0,3,3,0,3,1,3,0,2,2,0,1,3,0,1,0,3,0,1,3,1,2,2,0,0,3,0,1,3,2,3,2,1,
    					  0,3,2,2,0,3,3,0,3,0,0,1,0,2,0,0,0,2,1,2,0,2,2,3,3,3,0,0,1,1,3,0,0,0,1,2,2,1,2,1,3,2,2,3,
    					  1,3,0,1,1,1,3,0,0,0,2,0,2,0,3,1,2,3,3,2,2,2,0,0,0,1,0,0,0,0,3,0,0,0,3,0,2,1,2,3,1,0,3,3,
    					  2,0,1,1,0,1,0,2,2,2,1,3,0,3,0,2,1,1,3,1,0,1,2,2,0,2,2,0,0,3,3,1,3,0,1,1,0,3,0,2,1,2,2,0,
    					  0,0,1,2,3,1,2,1,1,2,2,1,1,0,2,3,3,3,0,2,3,2,0,0,0,1,0,2,2,0,0,2,0,2,0,1,1,0,3,1,3,3,0,1,
    					  0,3,0,3,1,2,3,1,0,0,2,3,2,0,0,3,1,2,3,2,2,3,1,3,3,2,0,1,3,0,3,2,2,3,2,1,2,2,0,3,2,0,2,1,
    					  2,2,3,1,3,2,2,0,0,1,0,3,1,3,3,0,0,2,2,2,2,0,1,0,3,1,3,3,3,0,2,3,2,0,3,3,3,3,3,3,2,2,1,1,
    					  0,3,1,3,2,3,0,0,0,2,1,1,3,1,3,2,1,3,0,1,1,3,2,2,1,0,0,3,2,1,3,2,3,3,2,1,2,0,2,2,0,2,2,3,
    					  2,0,2,3,3,1,1,2,0,1,1,1,2,3,2,1,2,1,0,2,3,1,1,3,3,2,0,1,3,2,3,3,0,1,2,3,2,1,1,2,1,0,0,1,
    					  0,3,1,1,1,0,2,0,2,2,3,0,1,0,2,0,0,3,1,1,2,0,0,2,1,1,0,2,2,2,3,1,2,0,1,2,0,1,2,1,2,3,1,1,
    					  1,1,0,3,3,2,1,0,0,1,0,3,0,0,2,2,2,1,1,2,1,2,1,1,2,0,3,1,3,2,1,2,2,3,1,0,1,1,1,0,0,0,1,3,
    					  3,2,2,1,2,0,0,0,3,1,3,2,3,1,3,2,3,1,3,2,0,1,2,1,1,2,1,3,0,1,1,1,3,3,1,0,0,3,2,2,3,1,1,0,
    					  3,0,0,3,0,3,1,2,0,2,3,2,3,0,3,2,3,0,2,2,3,0,3,3,3,1,0,1,2,2,0,3,3,1,3,2,2,3,2,1,1,0,0,0,
    					  0,2,1,0,1,1,1,1,0,3,0,1,0,0,1,0,2,0,0,1,2,0,0,0,3,3,1,0,3,2,1,2,3,2,0,3,3,0,2,3,1,1,0,2,
    					  2,3,3,0,1,0,0,3,1,2,3,0,1,2,3,2,2,0,1,2,0,3,0,3,0,1,1,3,2,2,2,3,1,2,0,0,3,0,2,3,3,1,0,3,
    					  3,0,0,0,3,2,1,1,3,1,1,1,1,1,1,3,3,3,0,0,1,1,1,1,2,2,0,1,0,2,2,0,2,1,3,1,1,1,2,1,1,0,3,1,
    					  0,2,3,0,1,2,0,0,3,1,2,3,0,0,3,1,0,2,2,0,1,1,2,2,1,3,1,2,1,0,1,2,3,2,3,0,3,1,3,0,2,0,3,1,
    					  1,0,3,2,0,3,0,2,0,0,3,3,1,1,1,0,0,1,1,1,2,3,1,3,1,2,0,0,3,3,0,3,3,0,0,0,3,3,0,3,3,2,3,3,
    					  3,3,1,1,1,3,1,1,3,3,1,0,0,3,1,2,0,2,0,3,0,2,1,0,1,0,2,3,3,3,2,3,3,2,0,0,0,2,2,3,0,0,3,0,
    					  2,3,0,1,3,2,1,2,0,1,3,2,2,0,1,1,3,3,0,2,3,0,3,3,1,2,3,2,1,0,2,3,2,2,2,3,0,1,1,3,1,0,2,1,
    					  3,2,2,2,3,3,1,1,1,3,2,3,1,0,2,3,0,2,3,0,1,3,3,1,1,1,1,0,1,1,2,2,0,2,1,1,0,1,0,3,1,1,1,3,
    					  3,2,1,2,3,2,2,3,1,0,3,2,0,1,0,1,3,3,3,0,3,3,2,3,1,2,2,1,1,0,0,3,0};
		System.out.println(minSideJumps(obstacles));
	}
}
