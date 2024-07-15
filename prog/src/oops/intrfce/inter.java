package oops.intrfce;
  public class inter {
	  public void name() {
		  System.out.println(" My Nmae Is ABHINAV  ");
	  }
/*//public class inter implements printable{  
//	public void print(){
//		System.out.println("Hello");
//		
//	}  
//	public void drawable() {
//		System.out.println("draw a 3D object :");
//	}*/

	public static void main(String[] args) {
	 
		 printable obj = new ain();  
		obj.print(); 
		obj.drawable();
		obj.msg();
		///obj.cube(2);               ---error
		printable.cube(2);
		ain obj1= new ain();
		obj1.draw();
		obj1.drawable();
		obj1.msg();
		
		inter obj2= new inter();
		obj2.name();
		System.out.println(obj1.a);
	 }  
	  
  }

			  
			  
			
	


