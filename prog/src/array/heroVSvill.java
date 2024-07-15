package array;

import java.util.*;

public class heroVSvill {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of villain");

		int v = sc.nextInt();

		System.out.println("Enter the number of heroes");

		int n = sc.nextInt();

		System.out.println("Enter the total power of hero");

		int h = sc.nextInt();

		System.out.println("Enter the power of enemies");

		int arr[] = new int[v];

		for (int i = 0; i < v; i++) {

			arr[i] = sc.nextInt();

		}

		int d = h;

		for (int j = (v - 1); j >= 0; j--) {

			if (d >= arr[j]) {

				d = d - arr[j];

				if (d == 0) {
 
					n--;

					if (n == 0) {

						System.out.println(j);

						return;

					}

					d = h;

				}

			}

			else if (d < arr[j]) {

				n--;

				if (n == 0) {

					System.out.println(j + 1);

					return;

				}

				j++;

				d = h;

			}

		}

	}

}
