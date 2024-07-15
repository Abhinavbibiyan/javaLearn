package array;

public class singleElem {
	public static int singleNonDuplicate(int[] A) {
        int N=A.length;
        if(N==1) return A[0];
        if(A[0]!=A[1]) return A[0];
        if(A[N-1]!=A[N-2]) return A[N-1];
        
        int i=2;int j=N-2;
        while(i<=j){
            int mid=(i+j)/2;
            if(A[mid]!=A[mid-1] && A[mid]!=A[mid+1]){
                return A[mid];
            }
            if((mid%2==1 && A[mid]==A[mid-1]) || mid%2==0 && A[mid]==A[mid+1]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));
	}
}
