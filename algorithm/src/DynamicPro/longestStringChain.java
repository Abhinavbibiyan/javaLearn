package DynamicPro;
import java.util.*;
public class longestStringChain {
	public static boolean check(String s1,String s2){
        if(s1.length()!=s2.length()+1){
            return false;
        }
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second<s2.length()&& s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(s1.length()==first && s2.length()==second)
            return true;    
        return false;    
    }
    boolean comp(String s1,String s2){
        return s1.length()<s2.length();  
    }
    public static int solve(int n,String words[]){
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int maxi=1;//Comparator
        // Arrays.sort(words,new Comparator<String>(){
        //     public int compare(String thiis,String that){
        //         return thiis.length().compareTo(that.length());
        //     }
        // });
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        for(int i=0;i<n;i++){
            for(int pre=0;pre<i;pre++){

                if(check(words[i],words[pre]) && dp[i]<1+dp[pre]){
                    dp[i]=1+dp[pre];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    public static int longestStrChain(String[] words) {
        int n=words.length;
        return solve(n,words);
    }
    public static void main(String[] args) {
    	String words[]= {"xbc","pcxbcf", "xb","cxbc","pcxbc"};
    	Arrays.sort(words, Comparator.comparing(s->s.length()));
    	for(String s:words) {
    		System.out.println(s);
    	}
    	
    	System.out.println(longestStrChain(words));
	}
}
