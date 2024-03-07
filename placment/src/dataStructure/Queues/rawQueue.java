package dataStructure.Queues;

public class rawQueue {
	
   public static class queue{
	 static  int que[];
	 static  int size;
	 static int rear=-1;
	 public queue(int size){
		 que=new int[size];
		 this.size=size;
		 
		 
	 }
	 public static Boolean isEmpty() {
		 return rear == -1;
	 }
	 public static void add(int data) {
		 rear++;
		 que[rear]=data;
			 
	 }
	 public static int pop() {
		 if(isEmpty()) {
			 System.out.println("queue is empty ");
			 return -1;
		 }
		 int front=que[0];
		 for(int i=0;i<rear;i++) {
			 que[i]=que[i+1];
		 }
			 rear--;
			 return front;
	 }
	 public static int peek() {
		 
		 return que[0];
	 }
	 
   }
   public static void main(String[] args) {
	queue qu=new queue(10);
	qu.add(1);
	qu.add(2);
	qu.add(3);
	qu.add(4);
	qu.add(5);
	qu.add(6);
	qu.add(7);
	qu.add(8);
	 
	System.out.println(qu.pop());
	System.out.println(qu.pop()); 
	while(!qu.isEmpty()) {
		System.out.println(qu.peek());
		qu.pop();
		
	}
}
   
}
