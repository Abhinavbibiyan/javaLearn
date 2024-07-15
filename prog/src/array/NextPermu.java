package array;

public class NextPermu {

	    public static void nextPermutation(int[] nums) {
	        // Length of the array
	        int n = nums.length;
	        // Index of the first element that is smaller than
	        // the element to its right.
	        int index = -1;
	        // Loop from right to left
	        for (int i = n - 1; i > 0; i--) {
	            if (nums[i] > nums[i - 1]) {
	                index = i - 1;
	                System.out.println(nums[index]);
	                break;
	            }
	        }
//	        for (int i = 0; i <n-1 ; i++) {
//	            if (nums[i+1] > nums[i]) { 
//	                index = i ;
//	                break;
//	            }
//	        }
	        
	        // Base condition
	        if (index == -1) {
	            reverse(nums, 0, n - 1);
	            return ;
	        }
	        int j = n - 1;
	        // Again traverse from right to left to find first element
	        // that is greater than the above find element
	        for (int i = n - 1; i >= index + 1; i--) {
	            if (nums[i] > nums[index]) {
	                j = i;
	                System.out.println(nums[j]);
	                break;
	            }
	        }
	        // Swap the elements
	        swap(nums, index, j);
	        // Reverse the elements from index + 1 to the nums.length
	        reverse(nums, index + 1, n - 1);
	    }

	    private static void reverse(int[] nums, int i, int j) {
	        while (i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }

	    private static void swap(int[] nums, int i, int index) {
	        int temp = nums[index];
	        nums[index] = nums[i];
	        nums[i] = temp;
	    }
	    public static void main(String[] args) {
	    	int[] nums= {0,6,5,4,3,2,1};
	    	nextPermutation(nums);
	    	for(int e:nums)
	    	System.out.print(e+",");
	    	
		}
	}


