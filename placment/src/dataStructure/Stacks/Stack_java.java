package dataStructure.Stacks;
import java.util.*;
public class Stack_java {
	public static void pushAtBottom(int data,Stack<Integer> s) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		int top=s.pop();
		pushAtBottom(data,s);
		s.push(top);
		
	}
	public static void reverse(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		int top=s.pop();
		reverse(s);
		pushAtBottom(top,s);
	}

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(13);
		s.push(3);
		s.push(4);
		s.push(10);
		s.push(11);
		s.push(12);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		
		s.sort(null);
//		s.
//		System.out.println(s.pop());
//		System.out.println(s.peek());

//	    pushAtBottom(21,s);
//		reverse(s);
	    while(!s.isEmpty()) {
	    	System.out.println(s.peek());
	    	s.pop();
	  	}
		
		
	}

}
