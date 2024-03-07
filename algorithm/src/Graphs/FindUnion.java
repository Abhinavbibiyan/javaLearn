package Graphs;

public class FindUnion {

	static class disjoint {

		int n;
		int[] rank;
		int[] parent;

		disjoint(int n) {

			rank = new int[n];
			parent = new int[n];
			this.n = n;

			for (int i = 0; i < n; i++) {

				parent[i] = i;

			}
 
		}

		int find(int n) {

			if (parent[n] == n)
				return n;
			return parent[n] = find(parent[n]);

			/// path compression making common parent for all element that occur in the
			/// recursive path

			// return parent[n];

		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY)
				return;
			if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else if (rank[rootY] < rank[rootX]) {

				parent[rootY] = rootX;

			} else {

				parent[rootY] = rootX;
				rank[rootX]++;

			}
		}
	}

	public static void main(String[] args) {
		disjoint set = new disjoint(5);
		set.union(0, 2);
		set.union(4, 0);
		set.union(3, 1);
		System.out.println(set);
	}

}
