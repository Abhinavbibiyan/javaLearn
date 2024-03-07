package basic.recursion.backtracking;

class pair {
	int val;
	boolean found;

	pair(int val, boolean found) {

		this.found = found;
		this.val = val;
	}
}

public class longestRoute {

	public static pair findPath(int[][] mat, int i, int j, int x, int y, boolean[][] visit, int m, int n) {

		if (i == x && j == y) {
			return new pair(0, true);
		}

		if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] == 0 || visit[i][j])
			return new pair(Integer.MAX_VALUE, false);

		visit[i][j] = true;

		int res = Integer.MIN_VALUE;

		// Left

		pair sol = findPath(mat, i, j - 1, x, y, visit, m, n);
		if (sol.found) {
			res = Math.max(res, sol.val);
		}

		// Right
		sol = findPath(mat, i, j + 1, x, y, visit, m, n);
		if (sol.found) {
			res = Math.max(sol.val, res);

		}

		// up
		sol = findPath(mat, i - 1, j, x, y, visit, m, n);
		if (sol.found) {
			res = Math.max(sol.val, res);

		}
		// down

		sol = findPath(mat, i + 1, j, x, y, visit, m, n);
		if (sol.found) {
			res = Math.max(sol.val, res);

		}

		visit[i][j] = false;

		if (res != Integer.MIN_VALUE) {
			return new pair(res + 1, true);
		} else
			return new pair(Integer.MAX_VALUE, false);

	}

	public static void findLongestPath(int[][] mat, int xsrc, int ysrc, int xdst, int ydst) {

		int m = mat.length;
		int n = mat[0].length;
		boolean visit[][] = new boolean[m][n];
		pair sol = new pair(0, true);

		sol = findPath(mat, xsrc, ysrc, xdst, ydst, visit, m, n);
		if (sol.found) {
			System.out.println("reachable destination ");
			System.out.println(sol.val);
		} else
			System.out.println("Non reachable destination ");

	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
						{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		findLongestPath(mat, 0, 0, 1, 7);

	}

}
