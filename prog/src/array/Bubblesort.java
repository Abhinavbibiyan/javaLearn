package array;

public class Bubblesort {
	public static void bubble(int[] arr, int n ) {
		
		if(n==0 || n==1) return ;
		
		for(int i=0;i<n-1;i++) {
			 if(arr[i]>arr[i+1]) {
				 int temp=arr[i];
				 arr[i] =arr[i+1];
				 arr[i+1]=temp;
			 }
		}
		
		bubble(arr,n-1);
		
	}

	public static void main(String[] args) {

		int[] a = { 2, 5, 1, 3, 4, 6, 3, 8 };
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			boolean sort = true;
			for (int j = 0; j < n - i - 1; j++)  
			{
				if (a[j + 1] < a[j]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
					sort = false;
				}
			}
			if (sort)
				break;
		}
		for (int item : a) { // for each loop ;
			System.out.print(item + "  ");
		}
		System.out.println();
		
		int[] arr = { 2, 5, 1, 3, 4, 6, 3, 8 };
		
		bubble(arr,n);
		for (int item : arr) { // for each loop ;
			System.out.print(item + "  ");
		}
		
	}

}
