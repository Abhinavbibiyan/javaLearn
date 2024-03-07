package Graphs;
import java.util.ArrayList;
import java.util.Collections;
class Edge implements Comparable<Edge> {
	int Src, Dest, weight;
	Edge(int Src, int Dest, int weight) {
		this.Dest = Dest;
		this.Src = Src;
		this.weight = weight;
	}
	public int compareTo(Edge that) {
		return this.weight - that.weight;
	}
}
public class KruskalAlogo {
	static int[] parent;
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y); 
		if (rootX == rootY) {
			return;  
		}
		parent[rootY] = rootX;
	}
	static int find(int x) {
		if (parent[x] == x)
			return x;
		return find(parent[x]);
	}
	public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		ArrayList<Edge> edge = new ArrayList<>();
		boolean added[][] = new boolean[V][V];
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				ArrayList<Integer> cur = adj.get(i).get(j);
				if (!added[i][cur.get(0)]) {
					added[i][cur.get(0)] = true;
					added[cur.get(0)][i] = true;
					edge.add(new Edge(i, cur.get(0), cur.get(1)));
				}
			}
		}
		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
		Collections.sort(edge);
		int count = 1;
		int ans = 0;
		for (int i = 0; count < V; i++) {
			Edge edges = edge.get(i);
			int rootX = find(edges.Src);
			int rootY = find(edges.Dest);
			if (rootX != rootY) {
				union(rootX, rootY);
				count++;
				ans += edges.weight;
			}
		}
		return ans;
	}
}
