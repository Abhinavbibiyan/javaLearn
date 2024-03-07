package basic.strings; 
public class twoDbinaryS {
	static boolean searchB(int[][] arr,int n,int m, int row,int target){
		int s=0;
		int e=m-1;
		int mid=(s+(e-s)/2); 
		while(s<=e) {
			if(arr[row][mid]==target) {
				System.out.println(row +" "+ mid);
			
				return true;}
			
			if(arr[row][mid]<target) {
				e=mid-1;
			}
			if(arr[row][mid]>target) {
				s=mid+1;
			} 
			mid=(s+(e-s)/2); 
		}
		return false;}


	static boolean search(int[][] arr,int n,int m,int target) {
		int s=0;
		int e=n-1;
		int mid= s+(e-s)/2;
		while(s<=e) {
			// check starting
		 if(arr[mid][0]==target) {
				System.out.println(mid+ " "+ 0);
				return true;
			
		}
		 if(arr[mid][m-1]==target) {
			 System.out.println(mid+ " "+( m-1));
			 return true;
		 }
		 if((target>arr[mid][0]) && (target<arr[mid][m-1])) {
			 boolean ans=searchB(arr,n,m,mid,target);
			 return ans;
		 }
		 if(target < arr[mid][0]) {
			 e=mid-1;
			 
		 }
		 if(target > arr[mid][m-1]) {
		 s=mid+1;
		 }
		 mid= s+(e-s)/2;
	}
		return false;
		}
public static void main(String[] args) {
	//System.out.println("hello")
	//int[][] arr= new int[3][3];
int[][] arr={{1,5,9},{13,15,19},{20,33,43}};
int n=3;
int m=3;
int target =33;
System.out.println(search(arr,n,m,target));
}
} 
