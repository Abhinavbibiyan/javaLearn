package dataStructure.Queues;

import dataStructure.Queues.rawQueue.queue;

public class circularQueue {
	
	   public static class queue{
		 static  int que[];
		 static  int size;
		 static int front=-1;
		 static int rear=-1;
		 public queue(int size){
			 que=new int[size];
			 this.size=size;
			 
			 
		 }
		 public Boolean isEmpty() {
			 return rear == -1 && front==-1;
		 }
		 public static boolean isFull() {
			 return (rear+1)%size==front;
		 }
		 public void add(int data) {
			if(isFull()) {
				System.out.println("full queue");
		   return;
			}
			if(front==-1) {
				front=0;
			}
			 rear=(rear+1)%size;
			 que[rear]=data;
				 
		 }
		 public int pop() {
			 if(isEmpty()) {
				 System.out.println("queue is empty ");
				 return -1;
			 }
			 int res=que[front];
			 if(rear==front) {
				 rear=front=-1;
			 }
			 else {
				 front=(front+1)%size;
			 }
			 
				 return res;
		 } 
		 public int peek() {
			 
			 return que[front];
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
