 package lists.stack;

import java.util.Stack;
 // import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		 		
//		Vector<Integer> v= new Vector<Integer>();
//		 
//       for(int i=1;i<10;i++) {
//    	     
//		v.add(4*i);
//       }
//       System.out.println(v);

		
		Stack<Integer> s=new Stack<>(); 
		for(int i=1;i<10;i++) {
   	     s.push(i);
	}
		int popped=s.pop();
		System.out.println(popped);
		int popp=s.pop();
		System.out.println(popp);//in empty stack pop function produce an empty stack error
		int peek = s.peek();
		System.out.println(peek);
		

}}