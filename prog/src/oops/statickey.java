package oops;

import oops.person.b;
import oops.person.c;

public class statickey {
	
	static {                       ///these are static block 
		System.out.println("block 1"); // these exixute before the exicution of main class whereever they are either  on top or on bottom of main class
		
	}
	
	static {
		System.out.println("block 2");
		
	}
	
//	class person{
//		int age ;
//		String name;
//	    	static String breed="homo sapieans";
//		
//	}

	public static void main(String[] args) {
		 
		System.out.println(Math.PI);                       //we cannot make a obj of maths class 
		System.out.println(Math.max(50, 40)); 
		
		// so we us static keyword
		
		// if we want that no one can make an object of a class then make default constructor as private
		// in this type of class we can asses it using static mamber/keyword ->>see in math class
		  
		
		 person objA= new person();
		 
         person.b objb=objA.new b();////here to m=creat an object of a nested class we need to creat aan obj of main class  ,if  nested class is not static
         b objC=objA.new b();    //we can import class person.b  
         
         //b class is closely cuppled with person 
         c objD=new person.c();  // here we need not to create an obj of person class
         
         
	}
	static {
		System.out.println("block 3");
		
	}

}
