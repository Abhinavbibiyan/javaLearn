package oops.singolton;

public class appconfig {
private appconfig() {
	
}
  private static  appconfig obj = null;      //new appconfig();
 public static appconfig getInstance() {
	 if(obj==null) {
		 obj=new appconfig();
	 }
	 return obj;
 }
}
