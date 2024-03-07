package basic.recursion.backtracking;
import java.util.*;
public class problemOne {
	public  void solve(String tiles,String output,Set<String> result,Map<Integer,Boolean> flag) {
		for(int i=0;i<tiles.length();i++) { 
//			if(flag==0) {
//				char ch=tiles.charAt(i);
//				output.push_back(ch);
//				flag[i]=1;
//				result.insert(output);
//				solve( tiles, output, result, flag);
//				output.pop_back();
//				flag[i]=0;				
//			}
       }
		
	}
	public static int totalTile(String tiles) {
		String output="";
		Set<String>result=new HashSet<String>();
		Map<Integer,Boolean> flag=new HashMap<>();
	//	solve(tiles,output,result,flag);
		
//		
		return result.size();
	
}
	public static void main(String[] args) {
	 String tiles="AABBC";
	int total= totalTile(tiles);

	}

}
