package basic.recursion;

import java.util.LinkedList;
import java.util.Arrays;

public class permutationString {
	public static void swap(String str,int index,int i) {
		
	} 
	public static void Permutn(String str, String ans)
    {
 
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            // ith character of str
            char ch = str.charAt(i);
 
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
            // Recursive call
            Permutn(ros, ans + ch);
        }
    }
	public static void permutation(String str,int index,LinkedList<String>ans) {
		if(index>=str.length()) {
			ans.add(str);
			return ;
		}
		for(int i=index;i<str.length();i++) {
			swap(str,index,i);
			permutation(str,index+1,ans);
			swap(str,index,i);
			
		}
	}
	public static void main(String[] args) {
	
			String str="abc";
			LinkedList<String> ans=new LinkedList<>();
			String output="";
			//permutation(str,0,ans);
			Permutn(str,output);
			//System.out.println(ans);
		
	}
}
