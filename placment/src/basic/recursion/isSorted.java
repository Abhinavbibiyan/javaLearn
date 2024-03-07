package basic.recursion;

public class isSorted {
	
	public static int power(int a,int b) {
		if(b==0) return 1;
		if(b==1) return a;
		int ans=power(a,b/2);
		if(b%2==0) return  ans *ans;
		else
			return ans*ans*a;
	}
	public static boolean BinaryS(int[] arr, int start, int end , int ele) {
		if(start > end) return false;
		int mid=start + (end-start)/2;
		if(arr[mid]==ele) return true;
		if(arr[mid]<ele) return BinaryS(arr,mid+1,end,ele);
		else return BinaryS(arr,start,mid-1,ele);
 	}
	
	public static boolean search(int[] arr,int n, int elem) {
		if(n==0 && arr[0]!= elem) return false;
 		if(arr[n]==elem) return true ;
		
		return search(arr, n-1, elem);
 
	}
	
	public static int sum(int[] arr,int n) {
		 
		if(n==0) return arr[0];
		
		return arr[n]+sum(arr, n-1);
		
	}
	
	public static boolean isSort(int[] arr , int i) {
		int n=arr.length;
		if(i==n) return true;
		
		if(arr[i-1]>arr[i]) return false;
		
		return isSort(arr,i+1);
		
	}

	public static void main(String[] args) {
		int[] arr = {20,25,40,45,70,80, 90,100};
		int n=arr.length;
		System.out.println(isSort(arr,1));
		System.out.println(sum(arr,n-1));
		System.out.println(search(arr,n-1,21));
		System.out.println(BinaryS(arr,0,n,21));
		System.out.println(power(3,11));
	}
	
}
