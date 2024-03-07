package basic;

import java.util.Scanner;

public class element_search2d {
 
		   public static void main(String args[]) {
		       Scanner sc = new Scanner(System.in);
		       System.out.println("enter no row and colume : ");
		       int rows = sc.nextInt();
		       int cols = sc.nextInt();
		 
		       int[][] numbers = new int[rows][cols];
		       System.out.println("enter the element of matrix : ");
		       //input
		       //rows
		       for(int i=0; i<rows; i++) {
		           //columns
		           for(int j=0; j<cols; j++) {
		               numbers[i][j] = sc.nextInt();
		           }
		       }
		       System.out.println("enter the element of matrix you want to search : ");
		 
		       int x = sc.nextInt();
		 
		       for(int i=0; i<rows; i++) {
		           for(int j=0; j<cols; j++) {
		               //compare with x
		               if(numbers[i][j] == x) {
		                   System.out.println("x found at location (" + i + ", " + j + ")");
		               }
		           }
		       }
		 
		     
		 
		   }
		}


