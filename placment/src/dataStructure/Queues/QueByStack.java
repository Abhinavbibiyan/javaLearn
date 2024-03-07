package dataStructure.Queues;
import java.util.*;

    class queue{
	int N;
	Stack<Integer>s1=new Stack<>();
	Stack<Integer>s2=new Stack<>();
	
	public queue() {
		N=0;
	}
	   
	

		public void push(int a) {
			s1.push(a);
			N++;
		
		}
		public int pop() {
			if(s1.size()==0) {
				System.out.println("empty queue");
				return -1;
			}
			else {
			while(s1.size()!=1) {
				s2.push(s1.peek());
				s1.pop();
				N--;
			}
			int del=s1.peek();
			s1.pop();
			while(!s2.isEmpty()) {
				s1.push(s2.peek());
				s2.pop();
			}
			return del;
			}
		}
		public int front() {
			while(s1.size()!=1) {
				s2.push(s1.peek());
				s1.pop();
				N--;
			}
			int del=s1.peek();
			while(!s2.isEmpty()) {
				s1.push(s2.peek());
				s2.pop();
			}
			return del;
			
		}
}

public class QueByStack {

	public static void main(String[] args) {
		queue q= new queue();
		q.push(1);
		q.push(2);
		q.push(3);
//		q.push(4);
//		q.push(5);
//		q.push(6);
//		q.push(7);
		System.out.println(q.front());
		q.pop();
		System.out.println(q.front());
		q.pop();
		System.out.println(q.front());
		//q.pop();
		System.out.println(q.front());
	}
	
}
