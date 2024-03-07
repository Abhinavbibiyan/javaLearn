package basic.recursion;

import java.util.ArrayList;

public class placeTile {
	public static int placeTile(int n,int m) {  //1Xm  size tile in a grid
		if(m==n) {
			return 2;
		}
		if(n<m) {
			return 1;
		}
		//vertical
		int vertical=placeTile(n-m,m);
		
		//horizontally
		int horizontally=placeTile(n-1,m);
		
		return vertical+horizontally;
		
	}
	
	public static int noOfways(int n) {
		if(n<=1) return 1;
		
		//way 1 single guests
		int way1=noOfways(n-1);
		
		//way 2 guest in pair 
		int way2=(n-1)*noOfways(n-2);
		
		return way1+way2;
		
	}
	
	public static void print(ArrayList<Integer> subset) {
		for(int i=0;i<subset.size();i++) System.out.print(subset.get(i)+" ");
		
		System.out.println();
	}
	public  static void subSet(int n,ArrayList<Integer>subset) {
		
		if(n==0) {
			print(subset);
			return;
		}
		subset.add(n);
		// add integer
		subSet(n-1,subset);
		//remove --> backtrack
		subset.remove(subset.size()-1);
		subSet(n-1,subset);
	}
	public static void main(String[] args) {
//		int n=4,m=2;
//		int count=placeTile(n,m);
//		System.out.println(count);
//		System.out.println(noOfways(4));
		
		ArrayList<Integer>subset=new ArrayList<>();
		 
		subSet(2,subset);
		
	}
}
