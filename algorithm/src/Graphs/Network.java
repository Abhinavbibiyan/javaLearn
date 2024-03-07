package Graphs;
import java.util.*;

public class Network {
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
//		graph[2].add(new Edge(2,3));
//		graph[3].add(new Edge(3,1));
//		graph[4].add(new Edge(4,0));
//		graph[4].add(new Edge(4,1));
//		graph[5].add(new Edge(5,0));
//		graph[5].add(new Edge(5,2));
		
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));
		graph[2].add(new Edge(2,3));
		graph[2].add(new Edge(2,4));
		graph[3].add(new Edge(3,0));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));
		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		graph[5].add(new Edge(6,5));
	}
	
	public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]) {	
		System.out.print(curr +" ");
		vis[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(vis[e.des]==false) {
				dfs(graph,e.des,vis);
			}
		}
		
	}
	public static void bfs(ArrayList<Edge> graph[],int V) {
		Queue<Integer> q=new LinkedList<>();
		boolean[]vis=new boolean[V];
		q.add(0);
		while(!q.isEmpty()) {
			int curr=q.remove();
			if(vis[curr]==false) {
				System.out.print(curr+" ");
				vis[curr]=true;
				for(int i=0;i<graph[curr].size();i++) {
					Edge e=graph[curr].get(i);
					q.add(e.des);
				}
			}
		}
	}
	public static void printAllPath(ArrayList<Edge> graph[],boolean vis[],int curr,String path,int tar){
		 if(curr==tar) {
			 System.out.println(path);
			 return;
		 }
		 for(int i=0;i<graph[curr].size();i++) {
			 Edge e=graph[curr].get(i);
			 if(!vis[e.des]) {
				 vis[curr]=true;
				 printAllPath(graph,vis,e.des,path+"->"+e.des,tar);
				 vis[curr]=false;
			 }
		 }		 
	}
	public static boolean cycleUndirected(ArrayList<Edge>graph[],boolean vis[],int curr,int parent) {
		vis[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(vis[e.des] && parent!=e.des ) {
				return true;
				
			}else if(!vis[e.des]){
				if(cycleUndirected(graph,vis,e.des,curr));
				return true;
			}
			
		}
		return false;
	}
	
	public static boolean cycleDirectedGraph(ArrayList<Edge> graph[],int curr,boolean vis[],boolean recStack[]) {
		vis[curr]=true;
		recStack[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(recStack[e.des]) {
				return true;
			}else if(!vis[e.des] && cycleDirectedGraph(graph,e.des,vis,recStack)) {
				return true;
			}
			
		}
		recStack[curr]=false;
		return false;
	}
	
	public static void topsortUtil(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> st) {
		vis[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(!vis[e.des]) {
				topsortUtil(graph,e.des,vis,st);
			}
		}
		st.push(curr);
	}
	public static void topSort(ArrayList<Edge>graph[]) {
 		Stack<Integer>st=new Stack<>();
 		int V=graph.length;
 		boolean vis[]=new boolean[V];
 		
 		for(int i=0;i<V;i++) {
 			if(!vis[i]) {
 				topsortUtil(graph,i,vis,st);
 			}
 		}

 		while(!st.isEmpty()) {
 			System.out.print(st.pop()+" ");
 		}
	}
	public static void main(String args[]) {
		
		int V=7;
		
		/*
		 * 	  1-----3 
		 *   /      |  \
		 *  0 	    |    5---6
		 *   \      |  /
		 *	  2-----4
		 */
		 
		ArrayList<Edge> graph[]=new ArrayList[V];
		creatGraph(graph);
 		boolean vis[]=new boolean[V];
 		boolean recStack[]=new boolean[V];
//			bfs(graph,V);
//			System.out.println();
//			
//		for(int i=0;i<V;i++) {
//			if(!vis[i]) {
//				dfs(graph,i,vis);
//			}
//		}
//		System.out.println();
//		printAllPath(graph,vis,0,"0",5);
// 		for(int i=0;i<V;i++) {
// 			if(!vis[i]) {
// 				 boolean cycle=cycleDirectedGraph(graph,i,vis,recStack);
// 				 if(cycle) {
// 					 System.out.println(cycle);
// 					 break;
// 				 }
// 			}
// 		}		
 		topSort(graph);
 		
 		System.out.println();
 		System.out.println(cycleUndirected(graph,vis,0,-1));
	}	
}
