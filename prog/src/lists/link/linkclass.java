package lists.link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class linkclass {

	public static void main(String[] args) {
		List<Integer> ll= new LinkedList<>();
		List<Integer> al=new ArrayList<>();
//		ll.add(12);
//		ll.add(13);
//		ll.add(14);
//		ll.add(15);
//        ll.add(50);
//        System.out.println(ll.get(1));
//        ll.set(3, 55);
//        System.out.println(ll);
	
       timediff(al);
       timediff(ll);
	
	}
	
	static void timediff(List<Integer> list) {
		long start=System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
		//	list.add(i);//add in the last 
			list.add(0,i);//add at first  
			// in array it add at first and sift  first to second and second t third and so on ......
			//  but in linked list a new node is created at new place ; 
			
		}
		long end =System.currentTimeMillis();
		System.out.println(list.getClass().getName()+ " --> " + (end- start));
	}

}
