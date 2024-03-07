package DynamicPro;

import java.util.Arrays;

public class maxRectangle {

	static int kadane(int[] arr) {
		int maxSum=Integer.MIN_VALUE;
		int currSum=0;
		int size=arr.length;
		for(int i=0;i<size;i++) {
			currSum=currSum+arr[i];
			if(maxSum<currSum)
				maxSum=currSum;
			if(currSum<0)
				currSum=0;
		}
		return maxSum;
		
	}
	
	static int rectangleSum(int R,int C, int[][] matrix) {
		
		int[] subRectangle=new int[R];
		int Msum=Integer.MIN_VALUE;
		int Csum=0;
		
		for(int Cstart=0;Cstart<C;Cstart++) {
			Arrays.fill(subRectangle, 0);
			for(int Cend=Cstart;Cend<C;Cend++) {
				
				for(int row=0;row<R;row++) {
					
					subRectangle[row]+=matrix[row][Cend];
					
				}
				
				Csum= kadane(subRectangle);
				Msum=Math.max(Csum, Msum);
 			}
		}
		return Msum;
	}
	
	public static void main(String[] args) {
	
		  int arr[][] = new int[][] { 
									  { 1, 2, -1,-4,-20 },
						              { -8, -3, 4, 2, 1 },
						              { 3, 8, 10, 1, 3 },
						              { -4, -1, 1, 7, -6 } 
						              };
// Function call
              int R=arr.length;
              System.out.println(R);
              int C=arr[0].length;
              System.out.println(C);
              System.out.println( rectangleSum(R,C,arr));
		}
		
	}
	
	

