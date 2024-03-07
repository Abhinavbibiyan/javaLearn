package Graphs;
import java.util.*;

public class noOfcheapPath {
	class pair implements Comparable<pair>{
		int first;
		int second;
		pair(int first,int second){
			this.first=first;
			this.second=second;
		}
		public int compareTo(pair that) {
			return this.second-that.second;
		}
	}
	int countPaths(int n, List<List<Integer>> roads) {
		long dist[]=new long[n];
		int ways[]=new int[n];
		ArrayList<ArrayList<pair>> graph=new ArrayList<>();
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
		}
		int m=roads.size();
//		int src=roads.get(n)
		for(int i=0;i<m;i++) {
			int src =roads.get(i).get(0);
			int des=roads.get(i).get(1);
			int wei=roads.get(i).get(2);
			graph.get(src).add(new pair(des,wei));
			graph.get(des).add(new pair(src,wei));
		}
		Arrays.fill(dist,(long)1e18);
		Arrays.fill(ways,(int)1e9);
//		for(int i=0;i<n;i++) {
//			Arr
//		}
		int mod=(int)1e9+7;
		dist[0]=0;  
		ways[0]=1;
		PriorityQueue<pair> q=new PriorityQueue<>();
		q.add(new pair(0,0));
		while(!q.isEmpty()) {
			pair p=q.remove();
			int curr=p.first;
			int eff=p.second;
			for(int i=0;i<graph.get(curr).size();i++) {
				pair e=graph.get(curr).get(i);
				int neib=e.first;
				int edW=e.second;
				if(eff+edW<dist[neib]) {
					dist[neib]=eff+edW;
					ways[neib]=ways[curr];
					q.add(new pair(neib,eff+edW));
				}else if(eff+edW==dist[neib]) {
					ways[neib]=ways[curr]+ways[neib]%mod;
				}
			}
		}
		
		return ways[n-1]%mod;
	}
}
