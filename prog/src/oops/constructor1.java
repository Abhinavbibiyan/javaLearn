package oops;
    class vehicle{
    	int wheels;
    	String color;
    	int headlight;
    	vehicle(){
    		wheels=4; 
    		headlight =2;
    		                                                          //  constructor overloading ...similar to method /function overloading 
    	}
    	vehicle(int a,String color){
    		wheels =a;
    		headlight=2;
    		this.color=color;
    	}
    	vehicle(int wheels){
    		this.wheels =wheels;               /// this keyword point to current object
    		headlight=2;
    	}
    }
public class constructor1 {
      constructor1(){                
    	  System.out.println("object is now created");             // no argument constructor...
      }
	public static void main(String[] args) {
	 
   constructor1 a= new constructor1();
   vehicle car= new vehicle();
   vehicle car2=new vehicle();
   System.out.println(car.wheels + "  wheels " );
   System.out.println(car2.wheels + "  wheels  " );
   vehicle truck=new vehicle(8,"blue");
   System.out.println(truck.wheels +  " wheels ");
    System.out.println(truck.headlight + "  headlight");
    System.out.println(truck.color+  " color of vehicle "); 
	}
	

}
