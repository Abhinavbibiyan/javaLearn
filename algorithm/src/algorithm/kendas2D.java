package algorithm;

import java.util.*;

public class kendas2D {
	int Kadane(int[] arr, int cursumLeft, int cursumRight, int n) {
	      // function returns maxiumum sum of subarray and also updates 
	      // the left and right indices of the subarray in cursumLeft and  cursumRight respectively
	      int localSum = 0, globalSum = 0;
	      // variable to store the right index of current subarray
	      int localSumRight = 0;
	      // variable to store starting index of intermediate subarrays
	      int localCurStart = 0;
	      for (int i = 0; i < n; ++i) {
	        localSum += arr[i];
	        if (localSum < 0) {
	          localSum = 0;
	          localCurStart = i + 1;
	        } else if (localSum > globalSum) {
	          globalSum = localSum;
	          cursumLeft = localCurStart;
	          cursumRight = i;
	        }
	      }
	      return globalSum;
	    }

	int maximalRectangle(char[][] matrix) {
	      int globalMaxSum = 0;
	      // variables to indicate maximum submatrix boundaries
	      int finalLeft, finalRight, finalTop, finalBottom;
	      int rows = matrix.length; 
	      int cols = matrix[0].length; 
	      final int INF = -(rows * cols); 
	      // since there can be maximum of rows * cols number of 1's in the matrix 
	      // if we encounter 0 in a row in the current submatrix,
	      // our maximum sum submatrix can't contain this row as it should contain only 1's. 
	      // as we need to neglect the whole row,
	      // we need erase contributions of 1's in the same row which are before 0 
	      // hence we add INF to temp array before passing it to Kadane's algorithm

	      // set the left column
	      for (int left = 0; left < cols; ++left) {
	        int[] temp=new int[rows]; 
	        // temp is used to store sum between current left and right boundaries for every row.
	        
	        // set the right column corresponding to  left
	        for (int right = left; right < cols; ++right) {
	          // calculate sum between current left and right for each row
	          for (int i = 0; i < rows; ++i) {
	            if (matrix[i][right]=='1') {
	              temp[i]+=1;
	            } else {
	              temp[i]+=INF; 
	            }
	          }
	          // Find the maximum sum subarray in this created temp array using Kadane's 1D algorithm.
	          int localSum, localSumLeft = 0, localSumRight = 0;
	          localSum = Kadane(temp, localSumLeft, localSumRight, rows);
	          // compare sum with maximum sum so far.
	          // if sum is more, then update globalMaxSum
	          // and also update boundaries of maximum sum submatrix
	          if (localSum > globalMaxSum) {
	            globalMaxSum = localSum;
	            finalLeft = left;
	            finalRight = right;
	            finalTop = localSumLeft;
	            finalBottom = localSumRight;
	          }
	        }
	      }
	      return globalMaxSum; 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
