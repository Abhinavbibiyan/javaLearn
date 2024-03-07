package basic.recursion;

public class QuickSORT {
	
	public static int partition(int[] arr,int low,int high) {
		
		int pivot=arr[high];
		int i=low-1;
		
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				//swap
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		return i;	
	}
	public static void quickSort(int[] arr,int low,int high) {
		if(low>high) {
			return;
		}
		int pivot=partition(arr,low,high);
		quickSort(arr,low,pivot-1);
		quickSort(arr,pivot+1,high);
		
	}
	public static void main(String[] args) {
		int[] arr= {7,2,6,30,9,21,3,8};
		quickSort(arr,0,arr.length-1);
		for(int e:arr) {
			System.out.print(e +" ");
		}
	}

}
