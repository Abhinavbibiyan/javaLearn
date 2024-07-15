package array;

public class kokoBanana {
	public int mx(int[]arr){
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,arr[i]);
        }
        return ans;
    }
    public int time(int[]arr,int hr){
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            ans+=Math.ceil((double)arr[i]/(double)hr);
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int i=1;
        int j=mx(piles);
        int res=Integer.MAX_VALUE;

        while(i<=j){
            int mid=(i+j)/2;

            if(time(piles,mid)<=h){
                res=Math.min(res,mid);
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return res;

    }
}
