package DynamicPro;
import java.util.*;
public class printLCS {
	public static void longestCommonSubsequence(String s1, String s2) {
		int n=s1.length();
		int m=s2.length();
		int [][] dp=new int[n+1][m+1];
		int count=0;
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(s1.charAt(i)==s2.charAt(j)) {
					count=1+dp[i+1][j+1];
				}else {
					count=Math.max(dp[i+1][j],dp[i][j+1]);
				}
				dp[i][j]=count;
			}
		}
//		LinkedList<Character>ans=new LinkedList<>();
		String ans="";
		int i=0,j=0;
		while(i<n && j<m) {
			if(s1.charAt(i)==s2.charAt(j)) {
//				ans.addFirst(s1.charAt(i));
				ans+=s1.charAt(i);
				i=i+1;
				j=j+1;
			}else if(dp[i+1][j]>dp[i][j+1]){
				 i=i+1;
			}else {
				j=j+1;
			} 
		}
//		Collections.reverse(ans);
		System.out.println(ans);
	}
	public static void main(String[] args) {
//		String text1 = "KTEURFJS", text2 = "TKWIDEUJ" ;
//		longestCommonSubsequence(text1, text2);
		ArrayList<Integer> ans=new ArrayList<>();
		ans.add(1);
		ans.add(2);
		ans.add(3);
		System.out.println(ans);
		ans.add(0, 0);
		System.out.println(ans);
		ans.add(ans.size(), 4);
		System.out.println(ans);
	
	}     
}
