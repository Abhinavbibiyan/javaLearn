package oops.singolton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// appconfig obj=new appconfig();// here constructor is cLLING 
		
   appconfig obj=appconfig.getInstance();
   appconfig obj1=appconfig.getInstance();
   appconfig obj2=appconfig.getInstance();   ////
   appconfig obj3=appconfig.getInstance();
   appconfig obj4=appconfig.getInstance();
	}

}
