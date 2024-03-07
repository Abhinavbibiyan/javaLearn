package dataStructure.Stacks;
import java.util.*;
public class nextLargest {
	public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans=new long[n];
        Stack<Long>s=new Stack<>();
        s.push((long)-1);
        for(int i=n-1;i>=0;i--){
            long curr=arr[i];
            while(s.peek()<=curr && s.peek() !=-1){
                s.pop();
            }
            ans[i]=s.peek();
            s.push(curr);
        }
        
        return ans;
    } 
}
