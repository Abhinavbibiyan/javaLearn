package basic.recursion;

public class nokieKeypad {
	public static String[] keypad= {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	public static void combinationKey(String str,int idx,String newStr) {
		if(idx==str.length()) {
			System.out.println(newStr);
			return;
		}
		char currChar=str.charAt(idx); // return 2  for  str=23
		String mapping=keypad[currChar-'0'];
		for(int i=0;i<mapping.length();i++) {
			combinationKey(str,idx+1,newStr+mapping.charAt(i));
		}
		
	}
	public static void main(String[] args) {
		String str="53";
	
		combinationKey(str,0,"");
	}
	
}
