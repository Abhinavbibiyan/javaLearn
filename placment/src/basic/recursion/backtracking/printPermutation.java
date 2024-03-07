package basic.recursion.backtracking;

public class printPermutation {
	public static void printPermu(String str,String Per,int idx) {
		if(str.length()==0) {
			System.out.println(Per);
			return;
		}
		for(int i=0;i<str.length();i++) {
			char curChar=str.charAt(i);
			String newstr=str.substring(0,i)+str.substring(i+1);
			printPermu(newstr,Per+curChar,idx+1);
		}
	}
	public static void main(String[] args) {
		String str="ABHI";
		printPermu(str,"",0);
	}

}
