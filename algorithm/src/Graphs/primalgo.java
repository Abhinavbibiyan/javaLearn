package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

class pair implements Comparable<pair> {
	int wt;
	int v;
	pair(int wt, int v) {
		this.wt = wt;
		this.v = v;
	}
	@Override
	public int compareTo(pair that) {
		return this.wt - that.wt; 
	}
}
public class primalgo {
	public void spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		boolean[] vis = new boolean[V];
		PriorityQueue<pair> q = new PriorityQueue<>();
		q.add((new pair(0, 0)));
		int ans = 0;
		while (q.size() != 0) { 
			pair cur = q.remove();
			int u = cur.v;
			if (vis[u]) {
				continue;
			}
			ans += cur.wt;
			vis[u] = true;
			ArrayList<ArrayList<Integer>> neib = adj.get(u);
			for (ArrayList<Integer> list : neib) {
				int vertex = list.get(0);
				int wt = list.get(1);
				if (!vis[vertex]) {
					q.add(new pair(vertex, wt));
				}
			}
		}
  	}
}
