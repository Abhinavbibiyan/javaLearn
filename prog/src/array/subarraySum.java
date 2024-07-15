package array;
import java.util.*;
public class subarraySum {
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s){
		ArrayList<Integer>ans=new ArrayList<>();
		int start=0;
		int end=0;
		int sum=0;
		while(end<n) {
			sum+=arr[end]; 
			while(sum>s){
				sum-=arr[start];
				start++;
			}
			if(sum==s && start!=0){
				ans.add(start+1); 
				ans.add(end+1);
				return ans;			
			}
			end++;
		}   
		if(ans.size()==0) 
			ans.add(-1);
		return ans;
	}
	static int missingNumber(int array[], int n) {
        int result=0;
        int res=0;
        for(int i=1;i<=n;i++){
            res^=i;
            System.out.println("At i = "+ i + " "+res);
        }
        for(int i=0;i<n-1;i++){ 
            result^=array[i];
           System.out.println("for  "+array[i] +" -> " +result);
        }
        int xor=result^res;
        return xor;
    }
	public static void main(String[] args) {
		int N = 5, S = 12; 
		int	A[] = {1,2,3,7,5};
		int m= 10;
		int arr[]={1, 2 ,3, 4, 5, 7, 8, 9, 10, 11};
		System.out.println(subarraySum(A, N, S));
		System.out.println(11^13);	
		System.out.println(missingNumber(arr,m));	
	}
}