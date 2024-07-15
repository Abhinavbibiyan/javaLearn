package lists.link;



public class linkedlist<E> {

	Node<E> head;
	 public void add(E data) {
		Node<E> toAdd= new Node<E>(data);
		if(isEmpty()) { 
		
//		if(head==null) {
 			head=toAdd;
		return;
	}
		Node<E> temp=head ;
				while(temp.next!=null) {
					temp=temp.next;
					
				}
				temp.next=toAdd;
	}
	 void print() {
		Node<E> temp=head ;
		while(temp!=null) {
			System.out.print(temp.Data +  " ");
			temp=temp.next;
		}	
		
	}
	 public  boolean isEmpty()
	   {
	    return head ==null;  
	    }      // this return true if head is null
	 
	 
	 
	public E removeLast() throws Exception {
		
		Node<E> temp=head ;
		if(temp==null) {
			throw new Exception ("cannot remove last element from empty ");
		}
		
		
		if(temp.next==null) {
			Node<E> toRemove=head;
		 head=null;
		 return toRemove.Data;
		}
		while(temp.next.next!=null) {
			temp=temp.next;
	}
	  Node<E> toRemove=temp.next;
	  temp.next=null;
	  return  toRemove.Data;
	}
	
	public E getLast()throws Exception {
		
		Node<E> temp=head ;
		if(temp==null) {
			throw new Exception ("cannot peek last element from empty ");
		}
		
		
		 
		while(temp.next!=null) { 
			temp=temp.next;
	}
	  return temp.Data;
	} 
	
	
	public static class Node<E>{
		public E Data;
		public Node<E> next;
		
		public Node(E Data) {
			this.Data=Data;
			next=null;
		}
	}
}
