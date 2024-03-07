package dataStructure.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dataStructure.Map.student;

public class arrClass {
// @SuppressWarnings("unchecked")
public static void main(String[] args) {
	int[] no= {1,2,3,4,5,6,7,8,9,12,14,15,17,20};
	Arrays.asList(no);
	Arrays.stream(no, 0, 0);
	for(int e:no) {
		System.out.print(e+"  ");
	}
	
    int index=Arrays.binarySearch(no, 7);
    System.out.println("\n"+index);
//    for(int e:no) {
//		System.out.print(e+"  ");
//	}
    List<Integer> list=new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(5);
    list.add(3);
    list.sort(null);
    Iterator<Integer> i=list.iterator();
    Collections.sort(list,Comparator.reverseOrder());
//    Collections.
    System.out.println(list);
    System.out.println(Collections.min(list));
    System.out.println(Collections.frequency(list,2));
    List<student> stu=new ArrayList<>();
    stu.add(new student("abhi",1));
    stu.add(new student("go",4));
    stu.add(new student("AS",5));
    stu.add(new student("narakwasi",2));
    stu.add(new student("lBoi",3));
    Collections.sort(stu,new Comparator<student>() {
    		@Override
    		public int compare(student s1,student s2) {
    			return s1.name.compareTo(s2.name);
    			
    		}
    		
    });
    	
    	
    
    System.out.println(stu);
    student s1=new student("luck",10);
    student s2=new student("badluck",11);
    System.out.println(s1.compareTo(s2));
    
}
}
 