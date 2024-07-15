package cogoPort;
import java.util.*;
public class PowerFunc {
	public static int power(int base,int pow){
	    int temp;
	    if (pow == 0) return 1;
	    temp = power(base, pow / 2);
	    if (pow % 2 == 0) {
	        return temp * temp;
	    }else {
	        return base * temp * temp;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter base and pow");
		int base = sc.nextInt();
		int pow = sc.nextInt();
		System.out.println(power(base,pow));

	}

}
