package array;

public class shipLoad {
static int help(int[]arr,int n,int mid){
        
        int day=1;
        int load=0;
        
        for(int i=0;i<n;i++){
            if(load+arr[i]>mid){
                day+=1;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return day;
    }
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        // int l=Integer.MAX_VALUE;
        int l=0;
        int h=0;
        for(int e:arr){
            l=Math.max(l,e);
            h+=e;
        }
        while(l<=h){
            int mid=(l+h)/2;
            int res=help(arr,N,mid);
            if(res<=D){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
