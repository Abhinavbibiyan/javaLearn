package array;

import java.util.Arrays;

public class agressiveCow {
	public static boolean help(int[] stalls,int k,int dist){
        int last=stalls[0];
        int count=1;
        for(int i=0;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                count++;
                last=stalls[i];
            }
        }
        if(count>=k){
            return true;
        }else{
            return false;
        }
    }
    public static int maxDistance(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        int i=0;
        int j=stalls[n-1]-stalls[0];
        
        while(i<=j){
            int mid=(i+j)/2;
            if(help(stalls,k,mid)){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return j;
    }
    public static void main(String[] args) {
		int position[] = {1,2,3,4,7};
		int m = 3;
		System.out.println(maxDistance(position,m));
	}
}
