package array;

public class SmallestDivisorSum {
	public static int mx(int nums[]){
        int n=nums.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        return maxi;
    } 
    public static int isDiv(int []nums,int mid){
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.ceil((double)nums[i]/(double)mid);
        }
        return res;
    }
    public static int smallestDivisor(int[] nums, int K) {
        int i=1;
        int j=mx(nums);
        while(i<=j){
            int mid=(i+j)/2;
            if(isDiv(nums,mid)<=K){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
    }
    public static void main(String[] args) {
		int[]A = {1 ,2 ,5 ,9};
		int thres=8;
		System.out.println(smallestDivisor(A,thres));
	}
}
