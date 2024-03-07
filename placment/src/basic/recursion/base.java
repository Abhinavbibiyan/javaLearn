package basic.recursion;
public class base {
public static void printSum(int n,int sum) {
	if(n==0) {
		System.out.println("sum = " +sum);
		return;
		
	}
	sum+=n;
	printSum(n-1,sum);
	
}
public static int catlan(int n) {
	if(n<=1) return 1;
	int ans=0;
	for(int i=0;i<n-1;i++) {
		ans+=catlan(i)*catlan(n-i-1);
	}
	return ans;
}
public static void fibonacci(int a,int b,int n) {
	 
	if(n==0) {
		return;
	}
	int c=a+b;
	System.out.println(c);
	fibonacci(b,c,n-1);
	
}
public static void factorial(int n,int sum) {
	if(n==1) {
		System.out.println("factorial is = "+ sum);
		return;
	}
	sum*=n;
	factorial(n-1,sum);
}
public static void printNumbers(int n) {
	if(n == 0) {
	return;
	}
	System.out.println(n);
	printNumbers(n-1);
	
	}

public static void main(String[] args) {
	//printNumbers(5);
//	printSum(3,0);
//	factorial(5,1);
//	int a=0,b=1,n=10;
//	
//	System.out.println(a);
//	System.out.println(b);
//    fibonacci(a,b,n-2);
    System.out.println(catlan(3));
}
}

