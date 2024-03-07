package dataStructure.Stacks;
import java.util.*;
public class histogramArea {
	public static long[] preSmall(long[] arr,int n){
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        long pre[]=new long[n];
        for(int i=0;i<n;i++){
            long curr=arr[i];
            while(s.peek()!=-1 && curr<=arr[s.peek()]){
                s.pop();
            }
            pre[i]=s.peek();
            s.push(i);
        }
        return pre;
    }
    public static long[] nextSmall(long arr[],int n){
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        long[] nex=new long[n];
        for(int i=n-1;i>=0;i--){
            long curr= arr[i];
            while(s.peek()!=-1 && curr<=arr[s.peek()]){
                s.pop();
            }
            nex[i]=s.peek();
            s.push(i);
        }
        return nex;
        // Stack<Integer> st = new Stack<>();
        // for(int i=n1-1; i>=0; i--){
        //     while(!st.isEmpty() && his[st.peek()] >= his[i]){
        //         st.pop();
        //     }
        //     if(st.isEmpty()){
        //         ngr[i] = n1;
        //     }else{
        //         ngr[i] = st.peek();
        //     }
        //     st.push(i);
        // }
        // return ngr;
    }
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        int m=hist.length;
        long pre[]=preSmall(hist,m);
        long nex[]=nextSmall(hist,m);
        long maxAre=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            long l=hist[i];
            if(nex[i]==-1){
                nex[i]=m;
            }
            long b=nex[i]-pre[i]-1;
            long are=l*b;
            
            maxAre=Math.max(are,maxAre);
        }
        return maxAre;
    }
}
