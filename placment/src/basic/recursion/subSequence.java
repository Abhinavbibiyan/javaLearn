package basic.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class subSequence {
	
	public static void powerSet(int[] arr, int index,ArrayList<Integer>output,ArrayList<ArrayList<Integer>>ans) {
		
		if(index>=arr.length) {
			ans.add(output);
			return ;
		}
		// exclude
		powerSet(arr,index+1,output,ans);
		
		// include
		 
		output.add(arr[index]);
		powerSet(arr,index+1,output,ans);
//		output.remove(output.size()-1);
		
	}

	public static void subSeq(String str,int index , String output, LinkedList<String> ans){
		
		if(index>= str.length()) {
			ans.addLast(output);
			return ;
		}
		
		// exclude
		
		subSeq(str,index+1,output,ans);
		
		//include
		output += str.charAt(index);
		subSeq(str,index+1,output,ans);
		
	}
	
	public static void main(String[] args) {
		String str="abcd";
		LinkedList<String> ans=new LinkedList<>();
		String output="";
		subSeq(str,0,output,ans);
		
		System.out.println(ans);
		
		int[]arr= {1,2,3};
		ArrayList<ArrayList<Integer>>ans1=new ArrayList<>();
		ArrayList<Integer> value=new ArrayList<>();
		powerSet(arr,0,value,ans1);
		System.out.println(ans1);
		
		
		
	}
}
