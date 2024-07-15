package array;

import java.util.*;

public class G1Q {
	public static void main(String[] args) {
		int[][] grid = { { 1, 59, 38, 33, 30, 17, 8, 63 },
					{ 37, 34, 31, 60, 9, 62, 29, 16 },
					{ 58, 1, 36, 39, 32, 27, 18, 7 }, 
					{ 35, 48, 41, 26, 61, 10, 15, 28 }, 
					{ 42, 57, 2, 49, 40, 23, 6, 19 },
					{ 47, 50, 45, 54, 25, 20, 11, 14 },
					{ 56, 43, 52, 3, 22, 13, 24, 5 },
					{ 51, 46, 55, 44, 53, 4, 21, 12 } };
		int L=8;
		 int[][] M = {    {9, 8, 3, 5},
		                  {1, 7, 9, 8},
		                  {3, 8, 6, 4},
		                  {6, 3, 9, 7}};
		 int N=4;
		 //int ans=solution.countPath(M,N);
		// System.out.println(solution.totalPath(N,N));
		   countPathSum(M,N);
	}


 
	public static void countPathSum(int[][] M, int N) {
		 ArrayList<ArrayList<Integer>>sum=new ArrayList<>();
		 int totalpath=0,path;
		path= totalPath(M,N-1,N-1,sum,totalpath);
	}
	static int totalPath(int[][]M,int x,int y, ArrayList<ArrayList<Integer>>sum,int p_no) {
		
		// TODO Auto-generated method stub
		if(x==0 || y==0) {
			sum.get(p_no).add(M[x][y]);
			return 1;
		}
	 
		 return  totalPath(M,x-1,y,sum,p_no++)+totalPath(M,x,y-1,sum,p_no++);
		
	}
}
