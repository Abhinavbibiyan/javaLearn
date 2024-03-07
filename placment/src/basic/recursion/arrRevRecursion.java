package basic.recursion;

public class arrRevRecursion {
	
	public static boolean isPallandrom(String str,int i,int j) {
		if(i>j) return true;
		
		if(str.charAt(i)!=str.charAt(j)) return false;
		
		return isPallandrom(str,i+1,j-1);
		
	}
	public static void reverse(int[] arr, int i, int j) {
		
		if(i>j) return;
		
		// swap first and last
		
		int temp= arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		reverse(arr, i+1,j-1);
		
	}
  
	public static void main(String[] args) {
		int[] arr = {10,20,25,40,45,70,80,90,100};
		int n=arr.length;
		reverse(arr,0,n-1);
		for(int e: arr) 
			System.out.print(e + " ");
		System.out.println();
		
		String str="aabbccddccbbaa";
		int len=str.length();
		System.out.println(isPallandrom(str,0,len-1));
	}

}
