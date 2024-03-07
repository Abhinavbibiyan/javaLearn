package Graphs;

import java.util.*;

import Graphs.Network.Edge;

public class subNetwork {
	static class Edge{
		int src;
		int des;
		int wt;
		Edge(int src,int des){
			this.src=src;
			this.des=des;
			this.wt=0;
			
		}
		Edge(int src,int des,int wt){
			this.src=src;
			this.des=des;
			this.wt=wt;
			
		}
	}
	public static void creatGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<Edge>();
		}

	}	

	public static class Pair implements Comparable<Pair> {
		int Node;
		int Dist;

		public Pair(int n, int d) {
			this.Node = n;
			this.Dist = d;
		}

		@Override
		public int compareTo(Pair that) {
			return this.Dist - that.Dist;// ascending order
			// return that.Dist-this.Dist descending order
		}

	}

	public static void dijkstraAlgo(ArrayList<Edge> graph[], int src, int V) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int dist[] = new int[V];
		for(int i=0;i<V;i++) {
			if(i!=src) {
				dist[i]=Integer.MAX_VALUE;
			}
		}
		boolean vis[] = new boolean[V];
		pq.add(new Pair(0, 0));
		while (!pq.isEmpty()) {
			Pair curr = pq.remove();
			if (!vis[curr.Node]) {
				 vis[curr.Node] = true;
				for (int i = 0; i < graph[curr.Node].size(); i++) {
					Edge e = graph[curr.Node].get(i);
					int u=e.src;
					int v=e.des;
					if (dist[u]+e.wt<dist[v]) {
						dist[v] = dist[u] + e.wt;
						pq.add(new Pair(e.des, dist[e.des]));
					}
				}
			}
		}
		 for(int i=0;i<V;i++) {
			 System.out.print(dist[i]+" ");
		 }
	}
	
	public static void bellmanFordAlgo(ArrayList<Edge>graph[],int src,int V) {
		int dist[]=new int[V];
		for(int i=0;i<V;i++) {
			if(i!=src) {
				dist[i]=Integer.MAX_VALUE;
			}
		}
		for(int k=0;k<V;k++) {
			
			for(int i=0;i<V;i++) {
				for(int j=0;j<graph[i].size();j++) {
					
					Edge e=graph[i].get(j);
					int u=e.src;
					int v=e.des;
					
					if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v]) {
						dist[v]=dist[u]+e.wt;
					}
				}
			}
		}
		for(int i=0;i<dist.length;i++) {
			System.out.print(dist[i]+" ");
		}
		
	}
	
	public static void primsMST(ArrayList<Edge> graph[],int src) {
		PriorityQueue<Pair> pq=new PriorityQueue<>();
		boolean vis[]=new boolean[graph.length];
		int cost=0;
		pq.add(new Pair(src,0));
		while(!pq.isEmpty()) {
			Pair cur=pq.remove();
			if(!vis[cur.Node]) {
				vis[cur.Node]=true;
				cost+=cur.Dist;
				for(int i=0;i<graph[cur.Node].size();i++) {
					Edge e=graph[cur.Node].get(i);
					if(!vis[e.des]) {
						pq.add(new Pair(e.des,e.wt));
					}
				}
			}
		}
		System.out.println(cost);
	}
	
	
	public static void main(String[] args) {
		int V = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Edge> graph[] = new ArrayList[V];
		creatGraph(graph);
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));  
		graph[2].add(new Edge(2, 4, 3));
		graph[3].add(new Edge(3, 5, 1));
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
		@SuppressWarnings("unchecked")
		ArrayList<Edge> graph2[]= new ArrayList[V];
		creatGraph(graph2);
		graph2[0].add(new Edge(0, 1, 2));
		graph2[0].add(new Edge(0, 2, 4));
		graph2[1].add(new Edge(1, 2, -4));
		graph2[2].add(new Edge(2, 3, 2));
		graph2[3].add(new Edge(3, 4, 4));
		graph2[4].add(new Edge(4, 1, -1));
		dijkstraAlgo(graph,0,V);
		System.out.println();
		bellmanFordAlgo(graph2,0,5);
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge> graph3[]=new ArrayList[4];
		creatGraph(graph3);
		graph3[0].add(new Edge(0,1,10));
		graph3[0].add(new Edge(0,2,15));
		graph3[0].add(new Edge(0,3,30));
		graph3[1].add(new Edge(1,0,10));
		graph3[1].add(new Edge(1,3,40));
		graph3[2].add(new Edge(2,0,15));
		graph3[2].add(new Edge(2,3,50));
		graph3[3].add(new Edge(3,1,40));
		graph3[3].add(new Edge(3,2,50));
		System.out.println();
		
		primsMST(graph3,0);
		
	}

}
