package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class G2Q {
	static Set<Character> union(Set<Character> s,Set <Character>s2){
//		Set<Integer> s3=new  HashSet<>();
		Iterator<Character> i =  s2.iterator();
		while(i.hasNext()) {
			s.add(i.next());
		}
		return s;
	}
  static int solve(String A,String B,String C,String D) {
	  int res=0;
	  
	  Set<Character> a=new HashSet<>();
	  for(int i=0;i<A.length();i++) {
		  a.add(A.charAt(i));
	  }
	  Set<Character> b=new HashSet<>();
	  for(int i=0;i<B.length();i++) {
		  b.add(B.charAt(i));
	  }
	  Set<Character> c=new HashSet<>();
	  for(int i=0;i<C.length();i++) {
		  c.add(C.charAt(i));
	  }
	  Set<Character> d=new HashSet<>();
	  for(int i=0;i<D.length();i++) {
		  d.add(D.charAt(i));
	  }
	  Set<Character> u=new HashSet<>();
	  union(u,a);
	  union(u,b);
	  union(u,c);
	  union(u,d);
	  res=u.size();
	  
	  return res;
  }
  public static void main(String[] args) {
	
}
}
