package DynamicPro;
import java.util.*;
public class longestIncresingSubsequence {
static int solve(int n,int[] arr , int cur,int pre ){
        
        if(cur==n) return 0;
        // include 
        int take=0;
        if(pre==-1 || arr[pre]<arr[cur]){
             take=1+solve(n,arr,cur+1,cur);
             
        }
        //exclude
            int notTake=0; 
            notTake=0+solve(n,arr,cur+1,pre);
        
        return Math.max(take,notTake);
        
        
    }
    //Function to find length of longest increasing subsequence.
    static int solveMem(int n,int[] arr,int cur,int pre,int[][] dp){
        
        if(cur==n) return 0;
        
        //include
        
        if(dp[cur][pre+1]!=-1) 
        return dp[cur][pre+1];
        int take=0;
        
        if(pre==-1 || arr[pre]<arr[cur]){
            take=1+solveMem(n,arr,cur+1,cur,dp);
        }
        //exclude
        
        int notTake=0;
        notTake=0+solveMem(n,arr,cur+1,pre,dp);
        
        return dp[cur][pre+1]= Math.max(take,notTake);
        
    }
    public static int solveA(int n,int[]a) {
    	int[]dp=new int[n];
    	int hash[]=new int[n];
    	Arrays.fill(dp,1);
    	int maxi=1;
    	int lastIndex=0;
    	for(int i=0;i<n;i++) {
    		hash[i]=i;
    		for(int pre=0;pre<i;pre++) {
    			if(a[i]>a[pre] && 1+ dp[pre]>dp[i]) {
    				dp[i]=1+dp[pre];
    				hash[i]=pre;
    			}
    		}
    		if(dp[i]>maxi) {
    			maxi=dp[i];
    			lastIndex=i;
    		}
    	}
    	ArrayList<Integer>temp=new ArrayList<>();
    	temp.add(a[lastIndex]);
    	while(hash[lastIndex]!=lastIndex) {
    		lastIndex=hash[lastIndex];
    		temp.add(a[lastIndex]);
    	}
    	Collections.reverse(temp);
    	System.out.println(temp);
    	return maxi;
    }
    public List<Integer> solve(int n,int[]arr){
        List<Integer>ans=new ArrayList<>();
        int dp[]=new int[n];
        int hash[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(arr);
        int maxi=1;
        int lastIndex=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int pre=0;pre<i;pre++){
                if(arr[i]%arr[pre]==0 && dp[i]<dp[pre]+1){
                    dp[i]=dp[pre]+1;
                    hash[i]=pre;
                }
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                    lastIndex=i; 
            }
        }
        ans.add(arr[lastIndex]);
        while(hash[lastIndex] !=lastIndex){
            lastIndex=hash[lastIndex];
            ans.add(arr[lastIndex]);
            
        }
        Collections.reverse(ans);
        return ans;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        
        return solve(n,nums);
    }
    static int longestSubsequence(int size, int a[])
    {
//        int[][] dp=new int[size+1][size+1];
//         for(int e[]: dp) {
//                	Arrays.fill(e, -1);
//                }
        // code here
        return solve(size,a,0,-1);
//       return solveMem(size,a,0,-1,dp);
//         return solveA(size,a);
       
    }
    public static void main(String[] args) {
    	int N = 16;
    	int[]A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15,7,5,15,16,11,18,20,18,23,22,24,21,25,17,18,19,26};
    	System.out.println(longestSubsequence(A.length,A));
//    	String words[]= {"xbc","zc","pcxbcf","ab","cxbc","pcxbc"};
//    	Arrays.sort(words, Comparator.comparing(s->s.length()));
//    	for(String s:words) {
//    		System.out.println(s);
//    	}
	}
}
