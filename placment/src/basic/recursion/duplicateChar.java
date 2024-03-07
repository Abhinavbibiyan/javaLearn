package basic.recursion;

import java.util.Arrays;

public class duplicateChar {
	public static Boolean map[]=new Boolean[26];
	public static void removeDup(String str,int idx,String newStr) {
		if(idx==str.length()) {
			System.out.println(newStr);
			return;
		}
		char currChar=str.charAt(idx);
				
		if(map[currChar -'a']==true){
			removeDup(str,idx+1,newStr);
			
		}else {
			newStr+=currChar;
			map[currChar -'a']=true;
			removeDup(str,idx+1,newStr);
		}
	}
	public static void seq(String str,int idx,String newStr) {
		if(idx==str.length()) {
			System.out.println(newStr + "-->"+ newStr.length());
			return;
		}
		char currChar=str.charAt(idx);
		
		// to be
		seq(str,idx+1,newStr+currChar);
		
		//not to be
		
		seq(str,idx+1,newStr);
	}

	public static void main(String[] args) {
		String str="abbccaad";
		Arrays.fill(map, false);
		removeDup(str,0,"");
		System.out.println("\n");
		seq("abc",0,"");
	}
}
