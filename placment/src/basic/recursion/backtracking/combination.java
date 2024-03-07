package basic.recursion.backtracking;
import java.util.*;
public class combination {
	private static void dfs(int n, int k, int i, List<Integer> path, List<List<Integer>> ans) {
	    if (path.size() == k) {
	      ans.add(new ArrayList<>(path));
	      return;
	    }
	    if(i<=n){
	      path.add(i);
	      dfs(n, k, i + 1, path, ans);
	      path.remove(path.size() - 1);
	      dfs(n, k, i + 1, path, ans);
	    }
	}
	    public static List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> ans = new ArrayList<>();
	        dfs(n, k, 1, new ArrayList<>(), ans);
	        return ans;
	    }
	    public static void main(String[] args) {
			int n = 4, k = 2;
			System.out.println(combine(n,k));
		}
}
