package string;
import java.util.*;
//import java.lang.*;
import java.io.*;
public class palldrom {
	//{ Driver Code Starts
	//Initial Template for Java




	// } Driver Code Ends
	//User function Template for Java

	    
	    // boolean isPal(String A){
	    //     int n=A.length();
	    //     for(int i=0;i<A.length/2;i++){
	    //         if(A.charAt(i)!=A.charAt(n-i)){
	                
	    //         return false;
	    //         }  
	    //     }
	    // }
	    
	 static boolean checkPalindrome(String str, int s, int e,String ans) 
	    { 
	        if (s == e)    // If there is only one character 
	            return true;  
	        // If first and last characters do not match 
	        if ((str.charAt(s)) != (str.charAt(e))) {
	            //str=str.charAt(e)+str;
	        	ans+=str.charAt(e);
	            return false;
	            //count=count+1;
	            // checkPalindrome(str, s + 2, e - 1,ans);
	        }
	        // If there are multiple characters, check if 
	        // middle substring is also palindrome or not. 
	        if (s < e + 1) 
	            return checkPalindrome(str, s + 1, e - 1,ans);   
	        return true; 
	    }   
	    public static int minChar(String str) {
	         int n = str.length();  
	         
	         int l=0,r=str.length()-1;
	         int temp=r;
	         int count=0;
	         while(l<r){
	             if(str.charAt(l)==str.charAt(r)){
	                 l++;
	                 r--;
	             }
	             else{
	                 count++;
	                 l=0;
	                 r=--temp;
	             }
	         }
	         return count;
	     }
//	          String ans="";
//	    // If string is empty,then it is palindrome 
//	        if (n == 0) 
//	            return 0;   
//	            
//	         checkPalindrome(str, 0, n - 1,ans); 
//	         return ans.length();
	         
	    }   
	        
	        
	       //Write your code here
	    


	//{ Driver Code Starts.

//	class GFG {
//		public static void main(String[] args) throws IOException
//		{
//		    var sc = new FastReader();
//		    int test = sc.nextInt();
//		    while(test-->0){
//	    		String s = sc.nextString();
//	    		System.out.println(Solution.minChar(s));
//		    }
//		}
//	    
//	    public static class FastReader
//		{
//			BufferedReader br;
//			StringTokenizer st;
//
//			public FastReader()
//			{
//				br = new BufferedReader(new InputStreamReader(System.in));
//				st = new StringTokenizer("");
//			}
//
//			private void read() throws IOException
//			{
//				st = new StringTokenizer(br.readLine());
//			}
//
//			public String nextString() throws IOException
//			{
//				while(!st.hasMoreTokens())
//					read();
//				return st.nextToken();
//			}
//
//			public int nextInt() throws IOException
//			{
//				return Integer.parseInt(nextString());
//			}
//
//			public long nextLong() throws IOException
//			{
//				return Long.parseLong(nextString());
//			}
//		}
//	}
	// } Driver Code Ends

