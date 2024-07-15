package string;

import java.util.*;

public class reversingstringwordbyword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//System.out.println("enter any string  a");
		//String s= sc.nextLine();
		String ans="";
	 	String s ="abhinav is a very good boy ";
//		 int i= s.length()-1;
//		 while(i>=0) {
//		     while(i>=0 && s.charAt(i)==' ')i--;
//		     int j=i;
//		     if(i<0) break; 
//		     while(i>=0 && s.charAt(i)!=' ')i--;
//		     if(ans.isEmpty())
//		         ans= ans.concat(s.substring(i+1,j+1));
//		     else
//		    	ans= ans.concat(" "+s.substring(i+1,j+1));
//		 }
//	 	for(int i=0;i<s.length();i++) {
//	 		ans =  s.charAt(i)+ ans;
//	 	}
	 	String str= "My Name is abhinav"; 
	 	String arr[] = str.split(" ");
	 	for(int i = arr.length-1 ; i >=0 ; i--){
	 	   System.out.print(arr[i] +" ");
	 	}
			 System.out.print(ans);
	}

}
