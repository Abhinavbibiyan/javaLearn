package DynamicPro;
import java.util.*;
public class largestBitonicSequence {
	public static int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n=nums.length;
        int dp1[]=new int[n];
        Arrays.fill(dp1,1);
        int maxi=0;
        
        for(int i=0;i<n;i++){
            for(int pre=0;pre<i;pre++){
                if(nums[i]>nums[pre] && dp1[i]<1+dp1[pre]){
                    dp1[i]=1+dp1[pre];
                    
                }
            }
        }
        int dp2[]=new int[n];
        Arrays.fill(dp2,1);
        for(int i=n-1;i>=0;i--){
            for(int pre=n-1;pre>i;pre--){
                if(nums[i]>nums[pre]  && dp2[i]<1+dp2[pre]){
                    dp2[i]=1+dp2[pre];
                }
            }
        }
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,dp1[i]+dp2[i]-1);
        }
        return maxi;
    }
	public static void main(String[] args) {
		int[]nums = {1, 2, 5, 3, 2};
		System.out.println(LongestBitonicSequence(nums));
	}

}
