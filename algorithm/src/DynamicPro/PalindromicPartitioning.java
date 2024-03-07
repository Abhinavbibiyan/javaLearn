package DynamicPro;
import java.util.*;
public class PalindromicPartitioning {
	static boolean isPalindrom(int i,int j,String temp){
        while(i<j){
            if(temp.charAt(i)!=temp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static int solve(int i,int n,String s,Integer dp[]){
        if(i==n) return 0;
        if(dp[i]!=null) return dp[i];
        int mini=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrom(i,j,s)){
                int cost=1+solve(j+1,n,s,dp);
                mini=Math.min(mini,cost);
            }
        }
        return dp[i]=mini;
    }
    static int solveT(int n,String s){
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int mini=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrom(i,j,s)){
                    int cost=1+dp[j+1];
                    mini=Math.min(mini,cost);
                }
            }
        dp[i]=mini;
        }
        return dp[0];
    }
    public static List<List<String>> partition(String s) {
        List<String> subList=new ArrayList<>();
        List<List<String>> list=new ArrayList<>();
        partion(s,0,subList,list);
        return list;
    }
    static void partion(String s, int index,List<String> subList,List<List<String>> list) {
        if (index==s.length()){
            list.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i <s.length() ; ++i) {
            if (isPalindrom(index,i,s)){
                subList.add(s.substring(index,i+1));
                partion(s,i+1,subList,list);
                subList.remove(subList.size()-1);
            }
        }
    }
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        // Integer dp[]=new Integer[n+1];
        // return solve(0,n,str,dp)-1;
        return solveT(n,str)-1;
    }
    public static void main(String[] args) {
		String str = "ababbbabbababa";
		System.out.println(palindromicPartition(str));
		List<List<String>>ans=partition(str);
		System.out.println(ans);
		System.out.println(partition("aab"));
	}
}
