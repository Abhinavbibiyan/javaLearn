package DynamicPro;

public class sortestCsupersequence {
	public static int solve(String s,String r,int m,int n){
	    int dp[][]=new int[m+1][n+1];
	    int ans=0;
	    for(int i=m-1;i>=0;i--){
	        for(int j=n-1;j>=0;j--){
	            if(s.charAt(i)==r.charAt(j)){
	                ans=1+dp[i+1][j+1];  
	            }else{
	                ans=Math.max(dp[i+1][j],dp[i][j+1]);
	            }
	            dp[i][j]=ans;
	        }
	    }
	    String res="";
		int i=0,j=0;
		while(i<m && j<n) {
			if(s.charAt(i)==r.charAt(j)){
				res+=s.charAt(i);
				i=i+1;
				j=j+1;
			}else if(dp[i+1][j]>dp[i][j+1]){
				res+=s.charAt(i);
				i=i+1;
			}else {
				res+=r.charAt(j);
				j=j+1;
			} 
		}
		while(i<m) {
			res+=s.charAt(i);
			i++;
		}
		while(j<n) {
			res+=r.charAt(j);
			j++;
		}
	    System.out.println(res);
	    return dp[0][0];
	}
	    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
	    {
	        //Your code herE
	        return m+n-solve(X,Y,m,n);
	    }
	    public static void main(String[] args) {
			String X = "efgh", Y = "jghi";
			int m=X.length();
			int n=Y.length();
			int ans=shortestCommonSupersequence(X,Y,m,n);
			System.out.println(ans);
		}
}
