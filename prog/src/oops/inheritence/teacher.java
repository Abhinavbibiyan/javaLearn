package oops.inheritence;

public class teacher extends person {
//	  teacher(){
//		  super(age);
//		  System.out.println("loki");
//	  }

	teacher(String name) {
		super(name);
		System.out.println("inside person class");
	}
	public void teach() {
		System.out.println(name + " is  teaching");
	}
	  public void eat() {
		  super.eat(); ////person's class function eat()
      	System.out.println("teacher "+ name + " is eating ");
      }
	  public static void laugh() {
      	System.out.println("teacher  is laughing ");
      }
      
}
