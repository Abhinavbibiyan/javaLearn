package DynamicPro;
import java.util.*;
public class mountainArray {
	public static int solve(int nums[]){
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];
    
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        // calculate the longest increase subsequence (LIS) for every index i
        for(int i=1 ; i < n ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(nums[i] > nums[j] && LIS[j]+1 > LIS[i])
                    LIS[i] = LIS[j]+1;
            }
        }
        
		// calculate the longest decreasing subsequence(LDS) for every index i and keep track of the maximum of LIS+LDS
        int max = 0;
        for(int i=n-2 ; i >= 0 ; i--)
        {
            for(int j = n-1 ; j > i ; j--)
            {
                if(nums[i] > nums[j] && LDS[j]+1 > LDS[i])
                    LDS[i] = LDS[j]+1;
            }
            /*step 3: now find longest bitonic subsequence 
    		but ensure that there something on the left and right of a particular index i 
    		inorder to make it a mountain  which means lis[i] > 1 and lds[i] > 1
    		*/
            if(LIS[i] > 1 && LDS[i] > 1) 
                max = Math.max(LIS[i]+LDS[i]-1, max);
        }
      //step 4: min remove is size of the original array - the length of the longest bitonic              subsequence found
        return n - max;
    }
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] ans1 = new int[n], ans2 = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1;i<n;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
                ans1[i] = list.size();
            }
            else{
                int idx = upperBound(list,nums[i]);
                list.set(idx,nums[i]);
                ans1[i] = idx+1;
            }
        }
        list.clear();
        list.add(nums[n-1]);
      
        for(int i=n-2;i>=0;i--){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
                ans2[i] = list.size();
            }
            else{
                int idx = upperBound(list,nums[i]);
                list.set(idx,nums[i]);
                ans2[i] = idx+1;
            }
        }

        int ans=0;
        for(int i=1;i<n-1;i++){
            if(ans1[i]>1 && ans2[i]>1){
                ans= Math.max(ans,ans1[i]+ans2[i]-1);
            }
        }

        return nums.length-ans;
    }

    private static int upperBound(ArrayList<Integer> list,int target){
        int i=0, j=list.size()-1;
        while(i<=j){
            int mid = (i+j)/2;

            if(list.get(mid)<=target){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return list.get(Math.max(j,0)) == target? j:i; // return last targetIndex | insertionIndex
    }
    public static void main(String[] args) {
		int[] nums = {2,1,1,5,6,2,3,1};
		System.out.println(minimumMountainRemovals(nums));
		System.out.println(solve(nums));
	}
}
