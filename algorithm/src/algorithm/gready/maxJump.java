package algorithm.gready;
public class maxJump {
	public static int jump(int arr[],int n) {
		if(n<=0) return 0;
		if(arr[0]==0) return -1;
		int curr=0;
		int max=0;
		int jump=0;
		for(int i=0;i<n-1;i++) {
			max=Math.max(arr[i]+i,max);
			if(i==curr){
				curr=max;
				jump++;
			}
			if(curr>=n-1)
				return jump;			
		}
		return -1;
	}
	public static void main(String[] args) {
		int N = 11 ;
		int	arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(jump(arr,N));
	}
}