package array;

public class quickFromFirstE {
 
	static int part(int[] arr,int s,int e) {
		int count=0;
		int pivot=arr[s];
		for(int i=s+1;i<=e;i++) {
			if(arr[i]<=pivot) {
				count++;
			}
		
		}
		int pivotIndex = s+count;
		int temp = arr[s];
		arr[s] = arr[pivotIndex];
		arr[pivotIndex] = temp;
		
		 int i=s,j=e;
		while(i< pivotIndex  && j> pivotIndex ) {
			while(arr[i]<= pivot ) {
				i++;
			}
			while(arr[j]>pivot) {
				j--;
			}
			if(i<pivotIndex && j>pivotIndex) {
				  temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
				i++;
			}
		}
		
		
		
		return pivotIndex;
		}
	
	static void quick(int[] arr,int s,int e){
		if(s>=e) {
			return;
		}
		int pivot=part(arr,s,e);
		quick(arr,s,pivot-1);
		quick(arr,pivot+1,e);
	}
public static void main(String[] args) {
	int[] arr= {1,5,8,2,8,3,9,13,23,5};
	quick(arr,0,9);
 for(int i=0;i<10;i++) {
	System.out.println(arr[i]);
 }
}
}
