package learn;

import java.util.Scanner;

public class student_class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char cont = 'Y';
		while (cont == 'Y') {
			int present = 0;
			int absent = 0;
			System.out.println("Enter no of student you want : ");
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				System.out.println("Enter name of " + i + "th Student ");
				String name = sc.next();
				System.out.println("Enter P(present) and A(absent) ");
				char Attendance = sc.next().charAt(0);
				if (Attendance == 'P') {
					present++;
				} else
					absent++;

			}

			System.out.println("Total Present Students =" + present + " Total no of students Absent =" + absent);
			System.out.println("Do you want to Restart or Exit (1/0): ");
			cont = sc.next().charAt(0);
		}

		System.out.println(
				"Program is over and done by" 
						+ " Mr. Abhinav Bibiyan from Kaithal Haryana India  ");
	}

}
