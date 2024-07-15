package array;

public class minRotatedArray {
	int findMin(int arr[], int n)
    {
        //complete the function here
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=n-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[i]<=arr[j]){
                ans=Math.min(ans,arr[i]);
                break;
            }
            if(arr[i]<=arr[mid]){
                ans=Math.min(ans,arr[i]);
                i=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                j=mid-1;
            }
        }
        return ans;
    }
}
