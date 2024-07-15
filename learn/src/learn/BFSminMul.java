package learn;
import java.util.*;
public class BFSminMul {
	static int mod=100000;
    int minimumMultiplications(int[] arr, int start, int end) {
        int dp[]=new int[100000];
        Arrays.fill(dp,-1);
        dp[start]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<arr.length;i++){
                int step=curr*arr[i]%mod;
                if(dp[step]==-1){
                    dp[step]=dp[curr]+1;
                    q.add(step);
                    if(step==end){
                        return dp[step];
                    }
                }
            }
        }
        return -1;
    }
}
