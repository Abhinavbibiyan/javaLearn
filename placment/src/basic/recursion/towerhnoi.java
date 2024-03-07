package basic.recursion;

public class towerhnoi {
	public static void towerOfHanoi(int n, String Source, String helper, String dest) {
		if (n == 1) {
			System.out.println("transfer disk " + n + " from " + Source + " to " + dest);
			return;
		}
		// transfer top n-1 from src to helper using dest as 'helper'
		towerOfHanoi(n - 1, Source, dest, helper);
		// transfer nth from src to dest
		System.out.println("transfer disk " + n + " from " + Source + " to " + dest);
		// transfer n-1 from helper to dest using src as 'helper'
		towerOfHanoi(n - 1, helper, Source, dest);
	}

	public static void main(String args[]) {
		int n = 3;
		towerOfHanoi(n, "SOURCE", "HELPER", "DESTINEY");
	}
}
