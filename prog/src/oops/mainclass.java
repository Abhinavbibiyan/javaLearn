package oops;
  class cat {
	     
	  cat(){
		                                        //constructor 
		                                         //same name as classs name ..........no return type
	  }
	  
	  
	  String color=new String ("  white  "), name= " kitty ";
	  int age;
	public  void walk() {
		                 System.out.println("cat is walking");
		                }
	public void eat()	{
		                  System.out.println("cat is eating");
	
	                     }
	public void desc() {
		         System.out.println("my cat name is"+ name+" and color is"+color+"age is  "+age);
	}
	  
  }
  class dog{
	  String color=new String (" white "), name= " tommy ";
	  int age;
	  public  void walk() {
		                 System.out.println("dog is walking");
		                }
	  public void eat()	{
		                  System.out.println("dog is eating");
	
	                     }
	  public void desc() {
	         System.out.println("my dog name is"+ name+" and color is"+color+"age is  "+age);
  }
	  }
public class mainclass {

	public static void main(String[] args) {
		cat cat1=new cat();
		cat1.age=5;
		cat1.walk();
		cat1.eat();
		dog dog1=new dog();
		dog1.age=4;
		dog1.walk();
		dog1.eat();
		cat1.desc();
		dog1.desc();
		 
		  System.out.println("this is opps");
		  
		  		
		
		

	}

}
