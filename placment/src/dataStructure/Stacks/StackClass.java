package dataStructure.Stacks;

public class StackClass {

	static class Node{ 
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
		static class stack{
			public static Node head;
			Boolean isEmpty() {
				return head==null;
			}
			public void push(int data) {
				Node newNode=new Node(data);
				if(isEmpty()) {
					head=newNode;
					return;
				}
				else {
					newNode.next=head;
					head=newNode;
				}
			}
			public int pop() {
				if(isEmpty()) {
					System.out.println("Op. not possible");
					return 0;
					
				}
				int elem=head.data;
				head=head.next;
				return elem;
			}
			public void peek() {
				System.out.println(head.data);
			}
			public void get() {
				if(isEmpty()) {
					System.out.println("stack is empty");
				}
				Node currNode=head;
				while(currNode.next!=null) {
					System.out.println(currNode.data);
					currNode=currNode.next;
				}
			}
			
		}
	
	public static void main(String[] args) {
		stack s =new stack();
		s.push(1);
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(8);
		s.push(10);
		s.push(12);
		s.push(14);
		s.peek();
		s.get();
		s.pop();
		s.get();
	}
}
