package oops.packages.models;

public class student {
    public String name;
    int password;
    public student(String name) {
    	this.name =name;
    }
    public String getname() {                       ///////default acess specifier can use in same package
	 return name;
	 
                         }
     private int getpassword() {
    	 return password;
                            }
     private String getpass() {
    	 return "agafg34t3########$";
                                }

}
