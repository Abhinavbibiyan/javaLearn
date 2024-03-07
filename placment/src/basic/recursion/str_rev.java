package basic.recursion;

public class str_rev {
	public static void strrv(String stri,int ind) {
		if(ind==0) {
				return;
		}
		System.out.print(stri.charAt(ind-1));
		strrv(stri,ind-1);
	}
		public static String revString(String str) {
	
		if(str.length() == 1) {
		return str;
		}
		char currChar = str.charAt(0);
		String nextString = revString(str.substring(1));
		return nextString + currChar;
		}
		public static void main(String args[]) {

		//String str = "abcd";
		//String reversed = revString(str);
		//System.out.println(reversed);
		String stri="abhinav bibiyan";
		strrv(stri,stri.length());
		}
		
}
