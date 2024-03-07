package basic;
import java.util.*;
public class array {

 
	   public static void main(String args[]) {
	       Scanner sc = new Scanner(System.in);
	       System.out.println("enter no row and colume : ");
	       int rows = sc.nextInt();
	       int cols = sc.nextInt();
	 
	       int[][] numbers = new int[rows][cols];
	 
	       //input
	       //rows
	       System.out.println("enter the element of matrix : ");
	       for(int i=0; i<rows; i++) {
	           //columns
	           for(int j=0; j<cols; j++) {
	               numbers[i][j] = sc.nextInt();
	           }
	       }
	 
	 
	       for(int i=0; i<rows; i++) {
	           for(int j=0; j<cols; j++) {
	                   System.out.print(numbers[i][j]+" ");
	               }
	               System.out.println();
	           }
	   }


}
