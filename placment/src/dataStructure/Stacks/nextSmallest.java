package dataStructure.Stacks;
import java.util.*;
public class nextSmallest {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    int ans[]=new int[n];
	    Stack<Integer> s=new Stack<>();
	    s.push(-1);
	    
	    for(int i=n-1;i>=0;i--){
	        int curr=arr[i];
	        while(curr<=s.peek()){
	            s.pop();
	        }
	        ans[i]=s.peek();
	        s.push(curr);
	    }
	    return ans;
	} 
}
