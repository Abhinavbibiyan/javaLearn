package basic.recursion.backtracking;
import java.util.Collections;

import java.util.LinkedList;

public class PhoneKey {
	
	public static void solveKey(String digit,int index,String output,LinkedList<String>ans,String[] mapping) {
		//base case
		if(index>=digit.length()) {
			ans.add(output);
			return;
			
		}
		
		int no=digit.charAt(index)-'0';
		String value=mapping[no];
		for(int i=0;i<value.length();i++) {
			
			output+=value.charAt(i);
			solveKey(digit,index+1,output,ans,mapping);
			output=output.substring(0, output.length()-1);
  
		}
		
		
	}
	
	public static void main(String[] args) {
		String digit="2244628";
		String[] mapping= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		LinkedList<String> ans=new LinkedList<>();
		String output="";
		solveKey(digit,0,output,ans,mapping);
		System.out.println(ans);
		
	}

}
