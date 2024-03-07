package basic.recursion;

public class mergSort {
	
	public static int partition(int[] arr,int low,int high) {
		
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				
			}
		}	
		i++;	
		int temp=arr[i];
		arr[i]=arr[high];
		arr[high]=temp;
		return i;	
		}
		
		
		
	
	
	public static void quick(int[] arr, int start, int end) {
		
		if(start<end) {
		int pivot=partition(arr,start, end);
		quick(arr,start,pivot-1);
		quick(arr,pivot+1,end);
	}
}
	public static void conqure(int arr[],int start, int mid, int end) {
		int index1=start;
		int index2=mid+1;
		int x=0;
		int[] arrTemp=new int[end-start+1];
		while(index1<=mid && index2<= end) {
    			if(arr[index1]<=arr[index2]) {
				arrTemp[x++]=arr[index1++];
			}else
				arrTemp[x++]=arr[index2++];
			
		}
		
		while(index1<=mid) {
			arrTemp[x++]=arr[index1++];
			
		}
		
		while(index2<=end) {
			arrTemp[x++]= arr[index2++];
		}
		
		for(int i=0,j=start;i<arrTemp.length;i++,j++) {
			arr[j]=arrTemp[i];
		}
		
		
	}
	public static void merg(int[]arr ,int start,int end) {
		if(start>=end) return ;
		
		int mid= start + (end-start)/2;
		
		merg(arr,start,mid);
		merg(arr,mid+1,end);
		
		conqure(arr,start,mid,end);
		
		
	}
	public static void main(String[] args) {
		int[] a = { 5, 16, 3, 32, 45, 74, 15, 14 };
		int n = a.length;
		quick(a, 0, n - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
