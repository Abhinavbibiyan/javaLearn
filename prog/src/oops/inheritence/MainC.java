package oops.inheritence;

public class MainC {

	public static void main(String[] args) {
		 
	 teacher t =new teacher("Mr. thor" );  // name is protected  here 
//	 person p= t;     // no need to new person();
	                 /// as teacher is a person   /// upcasting /implicet casting 
	 //2nd downcasting 
	   t.name ="abhinav";
	   System.out.println("abhi");
	   t.eat();
	   
	 
//	 teacher t1= new teacher();
//	  person p1= t1;                                      
//	                                    // we need to tell that person is a teacher ,,,, as person may be a teacher or may be a singer  
//	 teacher t2= (teacher )p1;     // here in upper line  we defined that  ( p is a teacher t1)
//	 // here we need to explcetly assigning p1 to t1 
//	 /// teacher t1= p1;
//	 
//	 boolean yo= t1 instanceof teacher;
//	 System.out.println(t1 instanceof teacher);
//	 System.out.println(t instanceof teacher);
//	 System.out.println(p1 instanceof teacher);
//	 System.out.println(p1 instanceof person);
//	 t.name="mr. bob";
//	 t.eat();
//	 t.walk();
//	 t.teach();
//	 singer s =new singer();   ///there is an override function 
//	 s.name= "jack";
//	 s.sing();	//method overiding work when paren and children both contain same method then only child class method is exicute 
//	  s.eat();	 
   
	}

}
