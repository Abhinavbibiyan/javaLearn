package oops;

import java.util.Scanner;
class ComplexNumbers {
	// Complete this class
	 int real;
     int imaginary;
    
    public ComplexNumbers(int real,int imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }

    public void plus(ComplexNumbers C){
        this.real = this.real + C.real;
        this.imaginary = this.imaginary + C.imaginary;
    }
    
    public void multiply(ComplexNumbers C){
    	int a=this.real;
        this.real = this.real*C.real - this.imaginary*C.imaginary;
        this.imaginary = a*C.imaginary + this.imaginary*C.real;
    }
    
    public void print(){
        System.out.println(real+" + "+(imaginary)+"i");
    }
    
}

public class Complex {
		public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//
//		int real1 = s.nextInt();
//		int imaginary1 = s.nextInt();
//
//		int real2 = s.nextInt();
//		int imaginary2 = s.nextInt();

        ComplexNumbers c=new ComplexNumbers(1,2);
		ComplexNumbers c2 =new ComplexNumbers(3,4);

//		int choice = s.nextInt();
//
//		 
//		if(choice == 1) {
//			// Add
//			c1.plus(c2);
//			c1.print();
//		}
//		else if(choice == 2) {
//			// Multiply
//			c1.multiply(c2);
//			c1.print();
//		}
//		else {
//			return;
//			
//		}
		//c.multiply(c2);
		c.print();
		c2.print();
		c.multiply(c2);
		c.print();
	}
}
