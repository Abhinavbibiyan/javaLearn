package oops.Encapsulation;

public class encpsulationintro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     student obj= new student();
     student obj1=new student();
//     obj.age=18;
//     obj.name="ajay";
     obj.setAge(50);
     obj1.setAge(17);
     System.out.println(obj1.getAge());
	}

}
