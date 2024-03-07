package DynamicPro;

public class minSquares {
	static int solve(int n,int[]dp){
	    if(n==0) return 0;
	    int ans=n;
	    if(dp[n]!=-1) return dp[n];
	     for(int i=1;i*i<=n;i++){
	        ans=Math.min(ans,1+solve(n-i*i,dp));
	    }
	    return dp[n]=ans;
	}   
	    static int solve1(int n){
	        int[] dp=new int[n+1];
	        dp[0]=0;
	         for(int j=1;j<=n;j++){
	            int ans=j;
	            for(int i=1;i*i<=j;i++){
	                if(j-i*i>=0){
	                    ans=Math.min(ans,1+dp[j-i*i]);
	                    
	                }    
	            }
	            dp[j]=ans;    
	         }
	        return dp[n]; 
	    }
	    static int[] nearestPerfectSquare(int N) {
	        double val=Math.sqrt(N);
	        int value=(int)val;
	        int ans[]=new int[2];
	        if(value==val)
	        {
	            ans[0]=N;
	            ans[1]=0;
	        }
	        else if(val>value)
	        {
	            int extra=value+1;
	            int one=value*value;
	            int two=extra*extra;
	            if(Math.abs(N-one)<Math.abs(N-two))
	            {
	                ans[0]=one;
	                ans[1]=Math.abs(N-one);
	            }
	            else
	            {
	                ans[0]=two;
	                ans[1]=Math.abs(N-two);
	            }
	        }
	        return ans;
	         // // code here
	         // int res[]=new int[2];
	         // int ans=solve(N);
	         // res[0]=ans*ans;
	         // res[1]=Math.abs(N-ans*ans);
	         // return res;
	     }
	    public static int MinSquares(int n)
	    {
	        return solve1(n);
	        // int[] dp=new int[n+1];
	        // Arrays.fill(dp,-1);
	        // return solve(n,dp);
	    }
	    public static void main(String[] args) {
			System.out.println(MinSquares(100));
			System.out.println(MinSquares(79839));
			System.out.println(nearestPerfectSquare(79839)[0]+" "+nearestPerfectSquare(79839)[1]);
			System.out.println(MinSquares(250));
			
		}
}
