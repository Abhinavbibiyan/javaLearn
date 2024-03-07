package Graphs;
import java.util.*;
public class cheapestFlight {
	public static class pair{
		int first;
		int second;
		pair(int first,int second){
			this.first=first;
			this.second=second;
		}
	}
	public static class triple{
		int first;
		int second;
		int third;
		triple(int first,int second,int third){
			this.first=first;
			this.second=second;
			this.third=third;
		}
	}
	
	public static int cheapFlight(int n,int[][] flight,int src,int des,int k) {
		ArrayList<ArrayList<pair>> graph=new ArrayList<>();
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());			
		}
		int m=flight.length;
		for(int i=0;i<m;i++) {
			graph.get(flight[i][0]).add(new pair(flight[i][1],flight[i][2]));
		}
		Queue<triple> q=new LinkedList<>();
		q.add(new triple(0,src,0));
		int dist[]=new int[n];
		for(int i=0;i<n;i++) {
			dist[i]=(int)(1e9);
		}
		dist[src]=0;
		while(!q.isEmpty()) { 
			triple curr=q.peek();
			q.remove();
			int steps=curr.first;
			int node=curr.second;
			int cost=curr.third;
			if(steps>k) continue;
			for(pair iter:graph.get(node)) {
				int neib=iter.first;
				int eW=iter.second;
				if(cost+eW<dist[neib] && steps <= k) {
					dist[neib]=cost+eW;
					q.add(new triple(steps+1,neib,cost+eW));
				}
			}
		}
		if(dist[des]==(int)(1e9))
			return -1;
		
		return dist[des];
		 
	}
}
