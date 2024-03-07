package DynamicPro;

public class booleanExpression {
	static int modulo =1003;
    static int solve(int i,int j,int isTrue,String exp,Integer[][][]dp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1){
                return exp.charAt(i)=='T'?1:0;
       
            }else{
                return exp.charAt(i)=='F'?1:0;
            }
        }
        if(dp[i][j][isTrue]!=null) return dp[i][j][isTrue]%modulo;
        int ways=0;
        
        for(int index=i+1;index<=j-1;index+=2){
            int leftTrue=solve(i,index-1,1,exp,dp);
            int leftFalse=solve(i,index-1,0,exp,dp);
            int rightTrue=solve(index+1,j,1,exp,dp);
            int rightFalse=solve(index+1,j,0,exp,dp);
            
            if(exp.charAt(index)=='&'){
                if(isTrue==1){
                    ways=(ways+ (leftTrue*rightTrue)%modulo)%modulo;
                }else{
                    ways=(ways+ (leftTrue*rightFalse)%modulo + (leftFalse*rightTrue)%modulo + (leftFalse*rightFalse)%modulo)%modulo;
                }
                
            }else if(exp.charAt(index)=='|'){
                if(isTrue==1){
                    ways=(ways + (leftTrue*rightTrue)%modulo + (leftTrue*rightFalse)%modulo+(leftFalse*rightTrue)%modulo)%modulo;
                }else{
                    ways=(ways + (leftFalse*rightFalse)%modulo)%modulo;
                }
            }else{
                if(isTrue==1){
                    ways=(ways+ (leftTrue*rightFalse)%modulo + (leftFalse*rightTrue)%modulo)%modulo;
                }else{
                    ways=(ways+(leftTrue*rightTrue)%modulo+(leftFalse*rightFalse)%modulo)%modulo;
                }
            }
            
        }
        return dp[i][j][isTrue]=ways;
    }
    static int countWays(int N, String S){
        // code here
        Integer[][][] dp=new Integer[N+1][N+1][2];
        return solve(0,N-1,1,S,dp);
    }
    public static void main(String[] args) {
		int N=35;
		String S="T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		System.out.println(countWays(N,S));
	}
}
