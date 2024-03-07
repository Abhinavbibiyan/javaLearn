package Graphs;

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class TopoSort {
	static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {

		if (V != res.length)
			return false;

		int[] map = new int[V];
		for (int i = 0; i < V; i++) {
			map[res[i]] = i;
		}
		for (int i = 0; i < V; i++) {
			for (int v : list.get(i)) {
				if (map[i] > map[v])
					return false;
			}
		}
		return true;
	}
}
	class Sol {
		int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

			Stack<Integer> s = new Stack<>();
			// add your code here
			int[] ans = new int[V];
			boolean vis[] = new boolean[V];
			for (int i = 0; i < V; i++) {
				if (!vis[i])
					dfs(i, adj, vis, s);
			}
			int i = 0;
			while (!s.isEmpty()) {
				ans[i++] = s.pop();
			}
			return ans;
		}

		public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> s) {
			vis[v] = true;
			for (int neib : adj.get(v)) {
				if (!vis[neib]) {
					vis[neib] = true;
					dfs(neib, adj, vis, s);
				}
			}
			s.push(v);

		}

		int[] KahnAlgo(int V, ArrayList<ArrayList<Integer>> adj) {
			// boolean[] vis=new boolean[V];
			ArrayList<Integer> ansList = new ArrayList<>();
			int[] inDeg = new int[V];
			for (ArrayList<Integer> list : adj) {
				for (Integer e : list) {
					inDeg[e]++;
				}
			}
			// for(int i=0;i<V;i++) {
			// if(!vis[i]) {
			bfs(V, adj, inDeg, ansList);
			// }
			// }

			int i = 0;
			int[] ans = new int[V];
			while (ansList.isEmpty()) {
				ans[i++] = ansList.get(i);
			}
			return ans;

		}

	public void bfs(int v,ArrayList<ArrayList<Integer>>adj ,int[]inDeg,ArrayList<Integer >ans) {
	 
	 Queue<Integer> q=new LinkedList<>();
	 //Map<Integer,E> m=new HashMap<>();
	 for(int i=0;i<v;i++) {
		 
		 if(inDeg[i]==0) {
			q.add(i); 
		 
	 }
		 while(!q.isEmpty()) {
			 int cur=q.poll();
			 ans.add(cur);
			 for(int neib:adj.get(cur)) {
				 if(--inDeg[neib]==0) {
					 q.add(neib);
				 }
			 }
		 }
	}
	} 
}