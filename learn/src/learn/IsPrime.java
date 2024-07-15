package learn;
import java.util.*;

public class IsPrime {

	public static void main(String[] args) {
		 int n, flag=0;
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Ente any no to check for prime and non prime : ");
		 n= sc.nextInt();
		int m=0;
		m=n/2;
		 if(n==1||n==0) {
			 System.out.println("no is prime ");
		 }
		 else {
			 for(int i=1;i<=m;i++) {
				 if(m%i==0) {
					 System.out.println("number  is not prime ");
					 flag=1;
					 break;
				 }
				 else
					 System.out.println("number  is PRIME ");
			 }
		 }

	}

}
