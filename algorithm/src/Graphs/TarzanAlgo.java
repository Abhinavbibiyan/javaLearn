package Graphs;
import java.util.*;

public class TarzanAlgo {
	public static class Edge{
		int src,des;
		Edge(int src,int des){
			this.src=src;
			this.des=des;
		}
	}
	public static void dfs(ArrayList<Edge> graph[],int curr,int parent,int[]dt,int low[],boolean[]vis,int time,boolean[]ap) {
		vis[curr]=true;
		dt[curr]=low[curr]=++time;
		int children=0;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			int neib=e.des;
			if(parent==neib) continue;
			else if(vis[neib]) {
				low[curr]=Math.min(low[curr], dt[neib]);
				
			}else {
				dfs(graph,neib,curr,dt,low,vis,time,ap);
				low[curr]=Math.min(low[curr], low[neib]);
				if(dt[curr]<=low[neib] && parent!=-1) {
					ap[curr]=true;
					
				}
				children++;
			}
		}
		if(parent ==-1 && children>1) {
			ap[curr]=true;
		}
	}
	public static void getAp(ArrayList<Edge>graph[],int V) {
		int dt[]=new int[V];
		int low[]=new int[V];
		int time=0;
		boolean vis[]=new boolean[V];
		boolean ap[]=new boolean[V];
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				dfs(graph,i,-1,dt,low,vis,time,ap);
			}
		}
		for(int i=0;i<V;i++) {
			if(ap[i]) {
				System.out.println("AP "+ap[i]);
			}
		}
		
		}
	public static void creatgraph(ArrayList<Edge>graph[],int V) {
		for(int i=0;i<V;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		graph[0].add(new Edge(0,3));
		
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,2));
		
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,1));
		
		graph[3].add(new Edge(3,0));
		graph[3].add(new Edge(3,4));
//		graph[3].add(new Edge(3,5));
		
		graph[4].add(new Edge(4,3));
//		graph[4].add(new Edge(4,5));
//		
//		graph[5].add(new Edge(5,3));
//		graph[5].add(new Edge(5,4));
	}
	public static void dfs(ArrayList<Edge>graph[],int curr,boolean[] vis,int[] dis,int []low,int time,int parent) {
		vis[curr]=true;
		dis[curr]=low[curr]=++time;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);  
			if(e.des==parent) continue;  
			else if(!vis[e.des]) {
				dfs(graph,e.des,vis,dis,low,time,curr);
				low[curr]=Math.min(low[curr],low[e.des]); 
				if(dis[curr]<low[e.des]) {
					System.out.println(curr+" <--Bridge--> "+e.des);
				}  
			}else if (vis[e.des]) {
				low[curr]=Math.min(low[curr],dis[e.des] );
			}
		}
	}
	public static void tarzan(ArrayList<Edge>graph[],int V) {
		int discover[]=new int[V];
		int low[]=new int[V];
		int time=0;
		boolean vis[]=new boolean[V];
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				dfs(graph,i,vis,discover,low,time,-1);
			}
		}
	}
	public static void main(String[] args) {
		int V=6;
		ArrayList<Edge> graph[]=new ArrayList[V];
		creatgraph(graph,V);
		tarzan(graph,V);
		getAp(graph,V);
	}
}
