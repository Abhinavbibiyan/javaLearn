package oops.polymorphism;

public class Main {
//	public static void repaircar(wagonR car) {
//		System.out.println("car is repaired");}
//		public static void repaircar(audi car) {
//			System.out.println("car is repaired");
//		
	public static void repaircar(car car) {
		System.out.println("car is repaired");
		
	}

	public static void main(String[] args) {
		 
		
		wagonR wagonr=new wagonR();
		audi audi =new audi();
	//	car car =new car();   //car is abstract class so no object and no body 
		repaircar(wagonr);
		repaircar(audi);
		

	}

}
