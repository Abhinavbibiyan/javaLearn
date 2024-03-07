package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuAlgo {
	
	public static class Edge{
		
		int des;
		int src;
		Edge(int src,int des){
			this.src=src;
			this.des=des;
			
		}
		
	}
	
	public static void creatGraph(ArrayList<Edge>graph[],int V) {
		for(int i=0;i<V;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		
	}
	
	public static void topSort(ArrayList<Edge> graph[],int curr,boolean[] vis,Stack<Integer> st) {
		vis[curr]=true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(!vis[e.des]) {
				topSort(graph,e.des,vis,st);
			}
					
		}
		st.add(curr);
		
	}
	public static void transpose(ArrayList<Edge>tran[], ArrayList<Edge> graph[],int V) {
//		ArrayList<Edge> tran[]=new ArrayList[V];
//		creatGraph(tran,V);
		for(int i=0;i<V;i++) {
			for(int j=0;j<graph[i].size();j++) {
				Edge e=graph[i].get(j);
				tran[e.des].add(new Edge(e.des,e.src));
				
			}
		}
//		return tran;
	}
	
	public static void dfs(ArrayList<Edge> tran[],int curr,boolean vis[]) {
		vis[curr]=true;
		System.out.print(curr+" ");
		for(int i=0;i<tran[curr].size();i++) {
			Edge e=tran[curr].get(i);
				if(!vis[e.des]) {
					dfs(tran,e.des,vis);
				}		
			
		}
	}
	public static void kosarajuAlgo(ArrayList<Edge> graph[],int V) {
		
		// step 1 topsort
		Stack<Integer> st=new Stack<>();
		boolean vis[]=new boolean[V];
		for(int i=0;i<V;i++) {
			if(!vis[i])
				topSort(graph,i,vis,st);
		}
		Arrays.fill(vis, false); 
		// step 2 transpose of graph
		
		ArrayList<Edge> tran[]= new ArrayList[V];
		for(int i=0;i<V;i++) {
			tran[i]=new ArrayList<Edge>();
		}
		transpose(tran,graph,V);
		
/*		ArrayList<Edge> tran[]=new ArrayList[V];
		for(int i=0;i<graph.length;i++) {
			vis[i]=false;
			tran[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<V;i++) {
			for(int j=0;j<graph[i].size();j++) {
				Edge e=graph[i].get(j);
				tran[e.des].add(new Edge(e.des,e.src));
			}
		}
*/		// step3; 
		
		//dfs on tran
		while(!st.isEmpty()) {
			int curr=st.pop();
				if(!vis[curr]) {
					dfs(tran,curr,vis);
					System.out.println();
				}
						
			}
		}
		
	
	public static void main(String[] args) {
		int V=5;
		ArrayList<Edge> graph[]=new ArrayList[V];
		creatGraph(graph,V);
		graph[0].add(new Edge(0,2));
		graph[0].add(new Edge(0,3));
		
		graph[1].add(new Edge(1,0));

		graph[2].add(new Edge(2,1));

		graph[3].add(new Edge(3,4));

		kosarajuAlgo(graph,V);
	}
	
	
	

}
