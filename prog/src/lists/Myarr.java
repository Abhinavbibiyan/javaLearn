package lists;

import java.util.ArrayList;  //  use for arraylist 
import java.util.LinkedList;
import java.util.List;

public class Myarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Boolean> truthordare=new ArrayList();
		truthordare.add(true);  
		truthordare.add(false);
		truthordare.add(true);
		truthordare.add(true);
		truthordare.add(false);
		
		ArrayList<String> fruit = new ArrayList();     /// its going to support only STring ;
		fruit.add("Apple");
		fruit.add("Banana");
		fruit.add("Mango");
		
		List<Integer> marks=new LinkedList<>();  /// here using "<>" in line we can directly convert it to array in fore each loop
		marks.add(95);
		marks.add(93);
		marks.add(100);
		
		
		List<Integer> rollno= new ArrayList(); 
		rollno.add(1);
		rollno.add(2);
		rollno.add(3);
		rollno.add(5);
		rollno.add(4);
		rollno.sort(null);
//		ArrayList fruit= new ArrayList();   it can supoort any data type
//		fruit.add("apple");
//		fruit.add(23);
		
		
		System.out.println(fruit);
		System.out.println(marks);
		System.out.println(truthordare);
		System.out.println(rollno);
		
         arrlist<String,Integer> list=new arrlist("abhinav",100);
         arrlist<Boolean, Integer>list2=new arrlist("true",100);
         
         list.GetDescreption();
	     list2.GetDescreption();
	     
	     fruit.add("orange");
	     
	     
	     marks.addAll(rollno);
	     System.out.println("after add rollno using addal function " + marks );
	     System.out.println(marks.get(5));
	     try {
	     System.out.println(fruit.get(10));}
	     catch(Exception e){
	    	 System.out.println("arry out of bound exception is occuring here ");
	    	 System.out.println("it is not a run time error so hendel it using error heandling ");
	    	 
	     }
	     System.out.println(fruit.get(2));
	     System.out.println(fruit.set(2,"stroberry"));
	     System.out.println(fruit.get(2));
	     
	     marks.removeAll(rollno);// as previously we add both marks and rollno now it remove rollno from updated marks
	     System.out.println(marks);// clear() can clear all elemnt 
	     System.out.println(fruit);
	     System.out.println(fruit.size());
	     String temp[]= new String[fruit.size()];
	     fruit.toArray(temp);
	     for(String e:temp) {
	    	 System.out.println(e);
	     }
	     marks.toArray();
	     for(int e: marks) {
	    	 System.out.println(e);
	    	 
	     }
	     
	     
	}
}
