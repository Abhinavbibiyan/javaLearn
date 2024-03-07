package dataStructure.Stacks;

import java.util.ArrayList;

public class Stack_Arraylist {
  public static class stack{
	 static ArrayList<Integer> list=new ArrayList<>();
	  public static boolean isEmpty() {
		  return list.size()==0;
	  }
	  public static void push(int data) {
		  list.add(data);
		  
	  }
	  public static int pop() {
		  if(isEmpty()) {
			  return -1;
		  }
		  int pop=list.get(list.size()-1);
		  list.remove(list.size()-1);
		  return pop;
	  }
	  public static int peek() {
		  if(isEmpty()) {
			  return -1;
		  }
		  return list.get(list.size()-1);
		  
	  }
	  public static void get() {
		  if(isEmpty()) {
			 System.out.println("empty"); 
		  }
		  for(int i=0;i<list.size();i++) {
			  System.out.println(list.get(i));
		  }
		 
	  }
  } 
  public static void main(String[] args) {
	stack s=new stack();
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	s.push(5);
	s.push(6);
	s.push(7);
	s.push(8);
	s.push(9);
	s.push(10);
	s.push(11);
	s.push(12);
	s.push(13);
//	s.get();
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.peek());
//	s.push(20);
//	s.get();
}
}
