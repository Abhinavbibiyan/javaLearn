package dataStructure.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Intro {
	static Set<Integer> union(Set<Integer> s,Set <Integer>s2){
//		Set<Integer> s3=new  HashSet<>();
		Iterator<Integer> i =  s2.iterator();
		while(i.hasNext()) {
			s.add(i.next());
		}
		return s;
	}
public static void main(String[] args) {
	Set<Integer> ts=new  HashSet<>();
	Set<Integer> s2=new  HashSet<>();
	TreeSet<Integer> s=new TreeSet<>();
	s.add(1);
	s.add(1);
	s.add(3);
	s.add(5);
	s.add(7);
	s.add(9);
	s.add(5);
	s.add(7);
	s.add(9);
	s.add(11);
	s.add(11);
	s2.add(13);
	s2.add(15);
	s2.add(17);
	s2.add(19);
	s2.add(21);
	s2.add(23);
	s2.add(25);
	System.out.println(s);
	System.out.println(s2);
	System.out.println(union(s,s2));
	
	System.out.println(s.higher(4));
 
}
}
