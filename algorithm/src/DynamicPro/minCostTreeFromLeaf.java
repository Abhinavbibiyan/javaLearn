package DynamicPro;
import java.util.*;

public class minCostTreeFromLeaf {
	class Pairs<K,V>{
		K key;
		V value;
		Pairs(K key,V value){
			this.key=key;
			this.value=value;
		}
	}
	public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        // To Store maximum value between the range
        Map<Pairs<Integer, Integer>, Integer> max = new HashMap<>();
        for(int i = 0; i < n; i++){
            max.put(new Pairs(i,i), arr[i]);
            for(int j = i + 1; j < n; j++){
                max.put(new Pairs(i, j), Math.max(arr[j], max.get(new Pairs(i, j - 1))));
            }
        }

        // return helper(arr, max, 0, n - 1);
        
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperMem(arr, max, 0, n - 1, dp);
    }

    public int helper(int[] arr, Map<Pairs<Integer, Integer>, Integer> max, int left, int right){
        if(left == right) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i = left; i < right; i++){
            ans = Math.min(ans, 
                max.get(new Pairs(left, i)) * max.get(new Pairs(i + 1, right)) 
                + helper(arr, max, left, i) + helper(arr, max, i + 1, right)
                );
        }
        return ans;
    }

    public int helperMem(int[] arr, Map<Pairs<Integer, Integer>, Integer> max, int left, int right, int[][] dp){
        if(left == right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        int ans = Integer.MAX_VALUE;

        for(int i = left; i < right; i++){
            ans = Math.min(ans,  
                max.get(new Pairs(left, i)) * max.get(new Pairs(i + 1, right)) 
                + helperMem(arr, max, left, i, dp) + helperMem(arr, max, i + 1, right, dp)
                );
        }
        return dp[left][right] = ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
