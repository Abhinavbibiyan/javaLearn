package oops.intrfce;

public interface printable {
	    
		void print();  
		void drawable();
	default	void msg() {
			  System.out.println("using default we can make a bidy of interface's method");
		}
	static void cube(int x) {
		System.out.println(x*x*x);
	}
		}  
 


