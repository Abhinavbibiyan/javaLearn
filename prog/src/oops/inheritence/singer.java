package oops.inheritence;

public class singer  extends person{    // using extends  singer become child of person class 
	
	singer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void sing() {
		System.out.println(name +" is  singing ");
	}
	  public void eat() {                  ///this is function is related to object
      	System.out.println("singer  "+ name + " is eating "); 
      }
	  public static void laugh() {     ///   this function is related to class 
      	System.out.println("singer  is laughing ");
      }
      
}

