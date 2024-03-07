package basic.recursion;

import java.util.LinkedList;

public class rateMaze {

	public static boolean isSafe(int row, int col, int[][] maze, int[][] visit, int m, int n) {
		if ((row >= 0 && row < m) && (col >= 0 && col < n) && maze[row][col] == 1 && visit[row][col] == 0) {
			return true;

		} else
			return false;

	}

	public static void path(int[][] maze, int row, int col, int[][] visit, String path, int m, int n,
			LinkedList<String> ans) {
		if (row == m - 1 && col == n - 1) {

			ans.add(path);
			System.out.println("ans = " + ans);

			return;
		}
		visit[row][col] = 1;
		// Down
		int newR = row + 1;
		int newC = col;
		if (isSafe(newR, newC, maze, visit, m, n) == true) {
			path += 'D';

			path(maze, newR, newC, visit, path, m, n, ans);
			path = path.substring(0, path.length() - 1);

		}
		// Left
		newR = row;
		newC = col - 1;
		if (isSafe(newR, newC, maze, visit, m, n) == true) {
			path += 'L';

			path(maze, newR, newC, visit, path, m, n, ans);
			path = path.substring(0, path.length() - 1);
		}
		// Right
		newR = row;
		newC = col + 1;
		if (isSafe(newR, newC, maze, visit, m, n) == true) {
			path += 'R';

			path(maze, newR, newC, visit, path, m, n, ans);
			path = path.substring(0, path.length() - 1);
		}
		// Up
		newR = row - 1;
		newC = col;
		if (isSafe(newR, newC, maze, visit, m, n) == true) {
			path += 'U';

			path(maze, newR, newC, visit, path, m, n, ans);
			path = path.substring(0, path.length() - 1);
		}

		visit[row][col] = 0;

	}

	public static void main(String[] args) {
//		int[][] maze={
//					{1, 0, 0, 0},
//					{1, 1, 0, 1},
//					{0, 1, 0, 0},
//					{1, 1, 1, 1}
//								};
		int maze[][] = {{ 1, 0, 0, 0, 0 },
						{ 1, 1, 1, 1, 1 }, 
						{ 1, 1, 1, 0, 1 }, 
						{ 0, 0, 0, 0, 1 },
						{ 0, 0, 0, 0, 1 } };
		int m = maze.length;
		int n = maze[0].length;

		int[][] visit = new int[m][n];

		String path = "";
		LinkedList<String> ans = new LinkedList<>();

		path(maze, 0, 0, visit, path, m, n, ans);

		System.out.println("Final paths = " + ans);

	}

}
