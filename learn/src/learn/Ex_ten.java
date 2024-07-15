 
package learn;
 import java.util.Scanner;
public class Ex_ten {

 
    public static void main(String[] args) {
        System.out.println("command line args = "+args[0]);
        System.out.println("command line args = "+args[1]);
        System.out.println("command line args = "+args[2]);
        System.out.println("command line args = "+args[3]);
        System.out.println("command line args = "+args[4]);
        Scanner s= new Scanner(System.in);
        // System.out.println(args[0]);
        // System.out.println(args[1]);
        // System.out.println(args[2]);
        // System.out.println(args[3]);
        // System.out.println(args[4]);
        // int sum = args[0]+ args[1]+ args[2]+ args[3]+ args[4];
        // int avg=sum/5;
        // System.out.println("avg of 5 args is = " + avg);
        System.out.println("enter any no from keyboard ");
        int i=s.nextInt();
        System.out.println(i);
    
}
}
