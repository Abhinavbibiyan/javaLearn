package array;
import java.util.Scanner;
import java.util.Arrays;
 
public class BinarySearch{

    // Binary Search
    public static void main(String [] args){
 
        Scanner sc = new Scanner(System.in);
 
        System.out.print(" Enter SIZE of the Array: ");
        int n = sc.nextInt();
       
        int [] arr = new int[n];
        
        System.out.print(" Enter " + n + " Elements: ");
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
 
        System.out.println(Arrays.toString(arr));
 
        System.out.print(" Enter target Element to Find: ");
        int target = sc.nextInt();
 
        System.out.println(target + " Found at Index: " + search(arr, target));
    }
    static int search(int[] nums, int target) {
        

        int start = 0;
        int end   = nums.length-1;
        while(start <= end){
            // find mid
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]> target) 
                end = mid-1;
            else
                start = mid +1;
        }
        return -1;
    }
}

