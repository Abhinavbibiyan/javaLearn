package DynamicPro;

public class buysell4 {
	public static int solveT(int n,int[]arr,int k){
        int[][][]dp=new int[n+1][2][k+1];
        
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int limit=1;limit<=k;limit++){
                    int ans=0;
                    if(buy==1){
                        int buykro= dp[i+1][0][limit]-arr[i];
                        int buyskip=dp[i+1][1][limit];
                        ans=Math.max( buykro,buyskip);
                    }else{
                        int sellkro= arr[i]+dp[i+1][1][limit-1];
                        int sellskip=dp[i+1][0][limit];
                        ans=Math.max(sellkro,sellskip);
                    }
                    dp[i][buy][limit]= ans;
                }
            }
        }
        return dp[0][1][k];
    }
	 public static int solveOp(int index,int oNo, int k,int[]arr,Integer[][]dp){
	        if(index==arr.length) return 0;
	        if(oNo==2*k) return 0;
	        if(dp[index][oNo]!=null) return dp[index][oNo];
	        int ans=0;
	        if(oNo%2==0){
	            int buykro= solveOp(index+1,oNo+1,k,arr,dp)-arr[index];
	            int buyskip=solveOp(index+1,oNo,k,arr,dp);
	            ans=Math.max( buykro,buyskip);
	        }else{
	            int sellkro=solveOp(index+1,oNo+1,k,arr,dp)+arr[index];
	            int sellskip=solveOp(index+1,oNo,k,arr,dp);
	            ans=Math.max(sellkro,sellskip);
	        }
	        return dp[index][oNo]=ans;
	    }
    static int maxProfit(int K, int N, int A[]) {
        // code here
    	Integer[][] dp=new Integer[N+1][2*K];
        return solveOp(0,0,K,A,dp);
//        return solveT(N,A,K);
        
    }
    public static void main(String[] args) {
		String s="jnd";
		String b="jfjsj";
		s=b;
		System.out.println(s);
	}
}
