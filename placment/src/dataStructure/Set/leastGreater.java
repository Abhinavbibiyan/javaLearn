package dataStructure.Set;
import java.util.*;
import java.util.TreeSet;
import java.util.Collections;

public class leastGreater {
	 public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
	        // code here
	        
	        ArrayList<Integer> ans=new ArrayList<>();
	        
	        TreeSet<Integer> s=new TreeSet<>();
//	        s.lower(null);
	        for(int i=n-1;i>=0;i--){
	            
	            int curr=arr[i];
	            
	            s.add(curr);

	            if(s.higher(curr)==null) ans.add(-1);
	            
	            else 
	                ans.add(s.higher(curr));
	        }
	        Collections.reverse(ans);
	   
	        return ans;
	 }
	 public static void main(String[] args) {
		System.out.println(findLeastGreater(6, new int[]{5,4,7,3,9,3}));
		
	}

}
