package array;

public class dayMbouquets {
	public static boolean ifPos(int M, int K, int[] bloomDay,int day){
        int ans=0;
        int cnt=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                ans+=cnt/K;
                cnt=0;
            }
        }
        ans+=cnt/K;
        return ans>=M;
    }
    public static int max(int[] bloomDay){
        int mx=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,bloomDay[i]);
        }
        return mx;
    }
    public static int mn(int[] bloomDay){
        int mi=Integer.MAX_VALUE;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            mi=Math.min(mi,bloomDay[i]);
        }
        return mi;
    }
    public static int solve(int M, int K, int[] bloomDay) {
        int n=bloomDay.length;
        long value = (long)M * (long)K;
        if(value > n) return -1;
        int i=mn(bloomDay);
        int j=max(bloomDay);
            while(i<=j){
               int mid=(i+j)/2;
               
               if(ifPos(M,K,bloomDay,mid)==true){
                   j=mid-1;
               }else{
                   i=mid+1;
               }
            }
        return i;
    }
    public static void main(String[] args) {
    	int M = 2, K = 3;
    	int[]bloomDay = {5, 5, 5, 5, 10, 5, 5};
    	System.out.println(solve(M,K,bloomDay));
	}
}
