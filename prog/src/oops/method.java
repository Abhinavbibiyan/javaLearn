package oops;

public class method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub                       //mathod overloding is when a class has two or more methode with same name but different argument 
		int fno=44;
		int sno= 65;
		int res= maxof(fno,sno);
		System.out.println(res);
		sayhi();

	}

	static int maxof(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
	static void  sayhi () {
		System.out.println("hi ");
		System.out.println("best of luck ");
		System.out.println("keep fighting for gole ");
	}
}
