package Graphs;
import java.util.*;
public class MinDistTopoSort {
	
    static class pair{
		int first;
		int second;
		pair(int first,int second){
			this.first=first;
			this.second=second;
		}
	}
    public static void topoSort(ArrayList<ArrayList<pair>> graph,int curr,boolean[]vis,Stack<Integer> s) {
    	vis[curr]=true;
    	for(int i=0;i<graph.get(curr).size();i++) {
    		int neib=graph.get(curr).get(i).first;
    		if(!vis[neib]) {
    			topoSort(graph,neib,vis,s);
    		}
    	}
    	s.add(curr);
    }
    public int[] shortPathTopo(int n,int m,int[][] edge) {
    	ArrayList<ArrayList<pair>>graph=new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		ArrayList<pair> temp=new ArrayList<>();
    		graph.add(temp);
    	}
    	for(int i=0;i<m;i++) {
    		int u=edge[i][0];
    		int v=edge[i][1];
    		int wt=edge[i][2];
    		graph.get(u).add(new pair(v,wt));
    	}
    	boolean vis[]=new boolean[n]; 
    	Stack<Integer> s=new Stack<>();
    	for(int i=0;i<n;i++) {
    		topoSort(graph,i,vis,s);
    	}
    	int dist[]=new int[n];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	while(!s.isEmpty()) {
    		int cur=s.pop();
    		for(int i=0;i<graph.get(cur).size();i++) {
    			int neib=graph.get(cur).get(i).first;
    			int wt=graph.get(cur).get(i).second;
    			if(wt+dist[cur]<dist[neib]) {
    				dist[neib]=dist[cur]+wt;
    			}
    		}
    	}
    	return dist;
    }
    public static void main(String[] args) {
		
	}
}
