package oops.Encapsulation;

public class student {
	private int age;
	private  String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
	     if(age>20) {
	    
	    	 System.out.println("you are to old to be a student in our school");
	    	 
	     }
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
