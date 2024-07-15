package array;

public class peakElem {
    static int findMaximum(int[] arr, int n) {
        // code here
        if(arr[0]>arr[1]) return arr[0];
        if(arr[n-1]>arr[n-2]) return arr[n-1];
        int i=1;
        int j=n-2;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }else if(arr[mid]>arr[mid-1]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    	int n = 9;
    	int arr[] = {1,15,25,45,42,21,17,12,11};
    	System.out.println(findMaximum(arr,n));
	}
}
