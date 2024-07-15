package array;

public class selectionsort {
	public static void main(String[] args) {
		int [] a= {3,9,4,8,2,5,1};
		int n=a.length;
		for(int i=0;i<n-1;i++)
		{   int minindex=i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[minindex]) {
					minindex=j;
				}
			}
			int temp=a[i];
			a[i]=a[minindex];
			a[minindex]=temp;
		}
		for(int item: a) {
			System.out.print(item +" ");
		}
	}

}