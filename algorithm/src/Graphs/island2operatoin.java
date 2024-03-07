package Graphs;

import java.util.*;

public class island2operatoin {
	class disjoint {
		int n;
		int parent[];
		int rank[];

		disjoint(int n) {
			this.n = n;
			parent = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
		}

		public int findParent(int n) {
			if (parent[n] == n)
				return n;
			return parent[n] = findParent(parent[n]);
		}

		public void union(int u, int v) {
			int pu = findParent(u);
			int pv = findParent(v);
			if (pu == pv)
				return;
			if (rank[pu] < rank[pv]) {
				parent[pu] = pv;

			} else if (rank[pv] == rank[pu])
				parent[pv] = pu;
			else {
				parent[pu] = pv;
				rank[pv]++;
			}
		}
	}

	public boolean isValid(int r, int c, int R, int C) {
		return r >= 0 && r < R && c >= 0 && c < C;

	}

	public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
		// Your code here
		int island[][] = new int[rows][cols];
		int cnt = 0;
		disjoint dis = new disjoint(rows * cols);
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < operators.length; i++) {
			int row = operators[i][0];
			int col = operators[i][1];
			if (island[row][col] == 1) {
				ans.add(cnt);
				continue;
			}
			island[row][col] = 1;
			cnt++;

			int[] drow = { -1, 0, 1, 0 };
			int[] dcol = { 0, 1, 0, -1 };
			for (int j = 0; j < 4; j++) {
				int newr = row + drow[j];
				int newc = col + dcol[j];
				if (isValid(newr, newc, rows, cols)) {
					if (island[newr][newc] == 1) {
						int node = row * cols + col;
						int adjNode = newr * cols + newc;
						if (dis.findParent(node) != dis.findParent(adjNode)) {
							cnt--;
							dis.union(node, adjNode);
						}
					}
				}
			}
			ans.add(cnt);
		}
		return ans;
	}

}
