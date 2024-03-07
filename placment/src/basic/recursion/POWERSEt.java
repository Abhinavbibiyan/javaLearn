package basic.recursion;
/// not complete  
public class POWERSEt {
  
	public static void solve(String a,String b,int in) {
		int n=a.length();
		if(in == n) {
			//System.out.println(b);
			return;
		} 
		 	
//		//exclude
//		 
//		
//		solve(a,b,in+1);
//		//include
//		 b.lastIndexOf(b.charAt(in));
//		solve(a,b,in+1);
		System.out.println(b);
		 
        // Try appending remaining characters
        // to current subset
        for (int i = in + 1; i <n; i++)
        {
            b += a.charAt(i);
            solve(a, b, in);
 
            // Once all subsets beginning with
            // initial "curr" are printed, remove
            // last character to consider a different
            // prefix of subsets.
            b = b.substring(0, b.length() - 1);
        }
	
	}
	public static void main(String[] args) {
		String  a="abc";
		String  out="";
		solve(a,out,-1);
		
	}
}
