package lists.stack;

import lists.link.linkedlist;

public class mystack <E>{
	  private linkedlist<E>ll=new linkedlist<>();
	    void push(E e) {
	    	ll.add(e);
	    }
	 
	  E pop() throws Exception{
	   if(ll.isEmpty()) {
		   throw new Exception ("poping from empty stack is not allowed");
	   }
	 return  ll.removeLast();
	
	  } 
	  
	  E peek()throws Exception  {
		  if (ll.isEmpty()) {
			throw new Exception ("peeking is not allowed in empty stack");  
		  }
		  return ll.getLast();
		  
	  }

}
