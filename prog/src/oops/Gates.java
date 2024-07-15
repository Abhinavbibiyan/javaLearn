package oops;

public class Gates {
	public static void main(String[] args) {
		int a=5;	//0101   1*2^2+0*2^1+1*2^0   1010
		int b=4;	//0100   1011
		System.out.println(a|b);
		System.out.println(a&b);
		System.out.println(~a);
		System.out.println(~b);
	}
}
