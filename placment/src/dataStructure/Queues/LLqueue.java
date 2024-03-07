package dataStructure.Queues;

public class LLqueue {
 public static class Node{
	 int data;
	 Node next;
	 Node(int data){
		 this.data=data;
		 this.next=null;
		  	 }
	 
	 }
 public static class Queue{
	 static Node head=null;
	 static Node tail=null;
	 public static Boolean isEmpty() {
		 return head==null&&tail==null;
	 }
	 public static void add(int data) {
		 Node newNode =new Node(data);
		 if(tail==null) {
			 tail=head=newNode;
			 return;
		 }
		 tail.next=newNode;
		 tail=newNode;		 
	 } 
	 public static int pop() {
		 if(isEmpty()) {
			 System.out.println("empty");
		 }
		 int front=head.data;
		 
		 if(head==tail) {
			 tail=null;
		 }
		 head=head.next;
		 return front;
				 
	 }
	 public static int peek() {
		 if(isEmpty()) {
			 System.out.println("empty");
			 return -1;
		 }
		 return head.data;
	 }
 }
 public static void main(String[] args) {
	Queue Q=new Queue();
	Q.add(4);
	Q.add(5);
	Q.add(44);
	Q.add(8);
	Q.add(9);
	Q.add(5);
	Q.add(41);
	Q.add(24);
	System.out.println(Q.pop());
	
}
}
