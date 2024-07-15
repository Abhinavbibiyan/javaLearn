package array;

import java.util.Scanner;

public class avragemark {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the no of students=");
		int n= sc.nextInt();
		int[] marks= new int[n];
        for(int i=0;i<n;i++)
        {   
        	marks[i]=sc.nextInt();
        	//System.out.println();
        } int avg=0;
        for(int j=0;j<n;j++)
        {
        	avg+=marks[j];
        }
        System.out.println("avg of marks ="+ avg/n);
	}

}
