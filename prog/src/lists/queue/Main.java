package lists.queue;

import java.util.*;

public class Main {

	public static void main(String[] args) {
	Queue<Integer>q= new LinkedList<>();
	
		q.add(2);
		q.add(4);
		q.offer(5);
		System.out.println(q); 
		System.out.println(q.remove());
		System.out.println(q);
		System.out.println(q.element());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.element());
		System.out.println(q.remove());
		System.out.println(q);
		System.out.println(q.poll());// when empty it show null on poll(pop)operation but on remove op. it throw exception 
		
		
		
		
		
		

	}

}
