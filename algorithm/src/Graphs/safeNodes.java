package Graphs;
import java.util.*;

import Graphs.TarzanAlgo.Edge;

public class safeNodes {
  static void creatGraph(ArrayList<Edge>graph[],int V) {
		for(int i=0;i<V;i++) {
			graph[i]=new ArrayList<Edge>();
		}		
		graph[0].add(new Edge(0,1));
		graph[1].add(new Edge(1,2));
		graph[2].add(new Edge(2,3));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));
		graph[4].add(new Edge(4,6));
		graph[5].add(new Edge(5,6));
		graph[6].add(new Edge(6,7));
		graph[8].add(new Edge(8,1));
		graph[8].add(new Edge(8,9));
		graph[9].add(new Edge(9,10));
		graph[10].add(new Edge(10,8));
		graph[11].add(new Edge(11,9));
		
		
//		graph[0].add(new Edge(0,1));
//		graph[0].add(new Edge(0,2));
//		graph[1].add(new Edge(1,2));
//		graph[1].add(new Edge(1,3));
//		graph[2].add(new Edge(2,5));
//		graph[3].add(new Edge(3,0));
////		graph[3].add(new Edge(3,5));
//		graph[4].add(new Edge(4,5));
////		graph[5].add(new Edge(5,6));

		for(int i=0;i<V;i++) {
			for(Edge e:graph[i]) {
				System.out.println(e.src+" --> "+ e.des);
			}
		} 
	}
	
	private static boolean dfs(ArrayList<Edge>[]graph,int curr,boolean[]vis,boolean recSt[],boolean[] check) {
		vis[curr]=true;
		recSt[curr]=true;
		check[curr]=false;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(!vis[e.des]) {
				if(dfs(graph,e.des,vis,recSt,check)) {
					return true;
				}
			}
			else if(recSt[e.des]) {
				return true;
			}
		}
		check[curr]=true;
		recSt[curr]=false;
		return false;
	}
	public static void safeNode(ArrayList<Edge>graph[],int V){
		boolean vis[]=new boolean[V];
		boolean recSt[]=new boolean[V];
		boolean check[]=new boolean[V];
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				dfs(graph,i,vis,recSt,check);
			}
		}
		
		List<Integer> safeNode=new ArrayList<Integer>();
		for(int i=0;i<V;i++) {
			if(check[i]) {
				safeNode.add(i);
			}
		}
		System.out.println(safeNode);
	}	
	public static void safeNodeTopSort(ArrayList<Edge> graph[],int V) {
		ArrayList<Edge> revGraph[] =new ArrayList[V];
		for(int i=0;i<V;i++) {    
			revGraph[i]=new ArrayList<Edge>();
		}
		int inDegree[]=new int[V];
		for(int i=0;i<V;i++) {
			//src--des
			//des--src
			for(int j=0;j<graph[i].size();j++) {
				Edge e=graph[i].get(j);
				revGraph[e.des].add(new Edge(e.des,e.src));
				inDegree[i]++;
			}
		}
		List<Integer> ans=new ArrayList<>();
		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<V;i++) {
			if(inDegree[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			
			int curr=q.poll();
			ans.add(curr);
			for(int i=0;i<revGraph[curr].size();i++) {
				Edge e=revGraph[curr].get(i);
				inDegree[e.des]--;
				if(inDegree[e.des]==0) {
					
					q.add(e.des);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Edge>graph[]=new ArrayList[12];
		creatGraph(graph,12);
		safeNode(graph,11);
		ArrayList<Edge>graph1[]=new ArrayList[12];
		creatGraph(graph1,12);
		safeNodeTopSort(graph1,11);
	}
}
