package DynamicPro;
import java.util.*;
class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}    
public class NinjaTrip {
	
	
	    public static int solve3(int[]cost,int[] days,int n){
	        Queue<pair>month=new LinkedList<>();
	        Queue<pair>week=new LinkedList<>();
	        
	        int ans=0;
	        for(int day:days){
	            
	            while(month.size()!=0 && month.peek().first+30<=day)
	                month.remove();
	            while(week.size()!=0 && week.peek().first+7<=day)
	                week.remove();

	            month.add(new pair(day,ans+cost[2]));
	            week.add(new pair(day,ans+cost[1]));

	            ans=Math.min(ans+cost[0],Math.min(month.peek().second,week.peek().second));
	        }
	        return ans;
	    }
	    public static int solve2(int[] cost,int[]day,int n){
	        int[] dp=new int[n+1];
	        Arrays.fill(dp,(int)1e8);
	        dp[n]=0;
	        for(int index=n-1;index>=0;index--){
	            int option1=cost[0]+dp[index+1];
	            int i;
	            for(i=index;i<n && day[i]<day[index]+7;i++);
	                int option2=cost[1]+dp[i];
	            
	            for(i=index;i<n && day[i]<day[index]+30;i++);
	                int option3=cost[2]+dp[i];
	             dp[index]=Math.min(option1,Math.min(option2,option3));
	        }
	        return dp[0];
	    }
		 public int solve(int index,int[] day,int[] cost,int n,int[] dp){
		     if(index>=n) return 0;
		     if(dp[index]!=-1) return dp[index];
		     int option1=cost[0]+solve(index+1,day,cost,n,dp);
		     int i;
		     for(i=index;i<n && day[i]<day[index]+7;i++);    
		         int option2=cost[1]+solve(i,day,cost,n,dp);
		    
		     for(i=index;i<n && day[i]<day[index]+30;i++);
		         int option3=cost[2]+solve(i,day,cost,n,dp);
		     return dp[index]=Math.min(option1,Math.min(option2,option3));
		 }
	    public static int mincostTickets(int[] days, int[] costs) {
	        
	        int n=days.length;
	        return solve3(costs,days,n);
	        // int[] dp=new int[n+1];
	        // Arrays.fill(dp,-1);
	        // return solve(0,days,costs,n,dp);
	    }
	    public static void main(String[] args) {
			int[]days = {1,2,3,4,5,6,7,8,9,10,30,31};
			int[] costs = {2,7,15};
			System.out.println(mincostTickets( days,costs));
			
		}
}
