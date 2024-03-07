package DynamicPro;

public class editDist3 {
	private int solve(String s, String t, int i,int j){
        if(i==s.length()) return t.length()-j;
        if(j==t.length()) return s.length()-i;
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            return solve(s,t,i+1,j+1);
        }else{
            //insert
            int insert=1+solve(s,t,i,j+1);
            //delete
            int delete=1+solve(s,t,i+1,j);
            //replace
            int replace=1+solve(s,t,i+1,j+1);
            
            ans=Math.min(insert,Math.min(delete,replace));
        }
        return ans;
    }
    private int solveM(String s, String t, int i,int j,Integer dp[][]){
        if(i==s.length()) return t.length()-j;
        if(j==t.length()) return s.length()-i;
        if(dp[i][j]!=null) return dp[i][j];
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            return solveM(s,t,i+1,j+1,dp);
        }else{
            //insert
            int insert=1+solveM(s,t,i,j+1,dp);
            //delete
            int delete=1+solveM(s,t,i+1,j,dp);
            //replace
            int replace=1+solveM(s,t,i+1,j+1,dp);
            
            ans=Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j]=ans;
    }
    public int solveT(String s,String t){
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int j=0;j<m;j++){
            dp[n][j]=m-j;
        }
        for(int i=0;i<n;i++){
            dp[i][m]=n-i;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans=0;
                if(s.charAt(i)==t.charAt(j)){
                    ans=dp[i+1][j+1];
                }else{
                    //insert
                    int insert=1+dp[i][j+1];
                    //delete
                    int delete=1+dp[i+1][j];
                    //replace
                    int replace=1+dp[i+1][j+1];
                    
                    ans=Math.min(insert,Math.min(delete,replace));
                }
            dp[i][j]=ans;
            }    
        }
        return dp[0][0]; 
    }
    public int editDistance(String s, String t) {
        // Code here
        // int n=s.length();
        // int m=t.length();
        // Integer dp[][]=new Integer[n+1][m+1];
        return solveT(s,t);
    }

}
