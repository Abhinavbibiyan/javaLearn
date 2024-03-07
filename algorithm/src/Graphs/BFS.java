package Graphs;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class graph {
	LinkedList<Integer> adj[];
	//
	//ArrayList<Integer> dp[]=new ArrayList[5];

	public graph(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
    
	public void edge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public int bfs(int source, int destination) {
		boolean visit[] = new boolean[adj.length];
		int parent[] = new int[adj.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		parent[source] = -1;
		visit[source] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == destination)
				break;
			for (int nei : adj[cur]) {
				if (!visit[nei]) {
					visit[nei] = true;
					q.add(nei);
					parent[nei] = cur;
				}
			}
		}
		int cur = destination;
		int dist = 0;
		while (parent[cur] != -1) {
			System.out.print(cur + " -> ");
			cur = parent[cur];
			dist++;
		}

		return dist;

	}

	private boolean dfshelp(int source, int destination, boolean vis[]) {
		if (source == destination)
			return true;
		for (int nei : adj[source]) {
			if (!vis[nei]) {
				vis[nei] = true;
				boolean isconnect = dfshelp(nei, destination, vis);
				if (isconnect)
					return true;

			}

		}
		return false;
	}

	public void dfs(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		System.out.println(dfshelp(source, destination, vis));
	}
}

class gra {
	public ArrayList<ArrayList<Integer>> obj = new ArrayList<>();

	gra(int v) {
		for (int i = 0; i <= v; i++) {
			obj.add(new ArrayList<Integer>());
		}
	}

	public void build(int source, int destination) {
		obj.get(source).add(destination);
		obj.get(destination).add(source);
	}

	public boolean Bfs(int source, int destination, int v, ArrayList<ArrayList<Integer>> obj, int[] pre, int[] dist) {
		LinkedList<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[v];
		for (int i = 0; i <= v; i++) {
			vis[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pre[i] = -1;
		}
		vis[source] = true;
		dist[source] = 0;
		q.add(source);
		
		while (!q.isEmpty()) {
			int cur = q.remove();
			for (int i = 0; i < obj.get(cur).size(); i++) {
				int neib = obj.get(cur).get(i);
				if (!vis[neib]) {
					vis[neib] = true;
					dist[neib] = dist[cur] + 1;
					pre[neib] = cur;
					q.add(neib);
					if (neib == destination)
						return true;
				}

			}
		}
		return false;
	}
}

public class BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of ver and edge");
	int v=sc.nextInt();
	int e=sc.nextInt();
	graph g=new graph(v);
	System.out.println("Enter "+e+"edges ");
	for(int i=0;i<e;i++) {
		int source=sc.nextInt();
		int destination=sc.nextInt();
		g.edge(source, destination);
	}
	System.out.println("Enter source and destination");
	
	int source = sc.nextInt();
	int destination = sc.nextInt();
	
	int distance = g.bfs(source, destination);
	System.out.println(" min distance is " + distance);
	g.dfs(source, destination);

		ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
		int vertex = sc.nextInt();
		int edge = sc.nextInt();
		gra gr = new gra(vertex);
		int[] pre = new int[vertex + 1];
		int[] dist = new int[vertex + 1];
		gr.Bfs(1, 6, vertex, obj, pre, dist);
		sc.close();

	}
}
