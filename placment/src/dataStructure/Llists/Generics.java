package dataStructure.Llists;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import genric.LL;
public class Generics {
	public static void main(String[] args) {
		List<String> fruit = new LinkedList();
		fruit.add("Apple");
		fruit.add("Banana");
		fruit.add("papaya");
		System.out.println(fruit);
		List<String> veg = new ArrayList();
		veg.add("tomato");
		veg.add("potato");
		veg.add("carrot");
		System.out.println(veg);
		pair<Integer, Float> p = new pair(20, 20.6);
		pair<String, Integer> p2 = new pair("Abhinav", 20);
		p.getDescription();
		p2.getDescription();
		fruit.addAll(veg);
		System.out.println(fruit);
		fruit.remove(4);
		System.out.println(fruit);
		fruit.removeAll(veg);
		System.out.println(fruit);
		String temp[]=new String[fruit.size()];
		fruit.toArray(temp);
		for(String e: fruit) {
			System.out.println(e);
			System.out.println();
		}
		for(String e: temp) {
			System.out.println(e);
		}
		LL ll=new LL();
		ll.push(1);
		ll.push(5);
		ll.print();
		System.out.println();
		ll.pop();
		ll.push(6);
		ll.push(7);
		ll.push(8);
		ll.print();
		System.out.println();
		ll.pop();
		ll.print();
	}

}
