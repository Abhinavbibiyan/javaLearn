package genric;

public class LL {
	node head;
	static class node<E>{
		public E e;
		node next;
		//node(){};
		node(E e){
			this.e=e;
			this.next=null;
		}}
		public <E> void push(E e) {
			node newnode=new node(e);
			if(head==null) {
				head=newnode;
			}
			else {
				 newnode.next=head;
				 head=newnode;
				
				
			}
		}
		public <E> void  pop()
		{    node remove =head;
		    head=head.next;
			
			
		}
		public <E> void print() {
			if(head==null) {
				System.out.println("empty");
				
			}
			else {
				node curr=head;
				while(curr !=null) {
					System.out.println(curr.e);
					curr=curr.next;
				}
			}
		}
	}
		
	


