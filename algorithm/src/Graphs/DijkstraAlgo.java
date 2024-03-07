package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	class Solution {
	     class pair implements Comparable <pair>{
	        int first;
	        int second;
	        pair(int first,int second){
	            this.first=first;
	            this.second=second;
	        }
	        // @Overide
	        public int compareTo(pair that){
	            return this.second-that.second;
	        }
	    }
	    public List<Integer> shortestPath(int n, int m, int edges[][]) {
	        // code here
	        int[]dist=new int[n+1];
	        int[]parent=new int[n+1];
	        for(int i=1;i<=n;i++){
	            parent[i]=i;
	            dist[i]=(int)1e9;
	        }
	        ArrayList<pair> graph[]=new ArrayList[n+1];
	        for(int i=0;i<=n;i++){
	            graph[i]=new ArrayList<pair>();
	        }
	        for(int i=0;i<m;i++){
	                graph[edges[i][0]].add(new pair(edges[i][1],edges[i][2]));
	                graph[edges[i][1]].add(new pair(edges[i][0],edges[i][2]));
	            
	        }
	        PriorityQueue<pair>pq=new PriorityQueue<>();
	        dist[1]=0;
	        pq.add(new pair(1,0));
	        while(!pq.isEmpty()){
	            pair pai=pq.remove();
	            int curr=pai.first;
	            int wt=pai.second;
	            for(pair p:graph[curr]){
	                int neib=p.first;
	                int edW=p.second;
	                if(wt+edW<dist[neib]){
	                    dist[neib]=wt+edW;
	                    parent[neib]=curr;
	                    pq.add(new pair(neib,wt+edW));
	                }
	            }
	        }
	        ArrayList<Integer>ans=new ArrayList<>();
	        if(dist[n]==(int)1e9){
	            ans.add(-1);
	            return ans;
	        }
	        
	        int node=n;
	        while(parent[node]!=node){
	            ans.add(node);
	            node=parent[node];
	        }
	        ans.add(1);
	        Collections.reverse(ans);
	        return ans;
	    }
	    
	}
	static class pair implements Comparable<pair> {
		int wt, v;

		pair(int v, int wt) {
			this.wt = wt;
			this.v = v; 
		}

		public int compareTo(pair that) {
			return this.wt - that.wt;
		}
	}
	public void shortest_distance(int[][] matrix)//Floyd Warshall algorithm
    {
        // Code here 
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=(int)1e9;
                }if(i==j){
                    matrix[i][j]=0;
                }
            }
        }
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==(int)1e9){
                    matrix[i][j]=-1;
                }
            }
        }
        return;
    }
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
		int[] ans = new int[V];
		PriorityQueue<pair> q = new PriorityQueue<>();
		boolean vis[] = new boolean[V];
		q.add(new pair(S, 0));
		// vis[S]=true;
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[S] = 0;
		while (!q.isEmpty()) {
			pair cur = q.poll();
			int u = cur.v;
			if (!vis[u]) {
				vis[u] = true;
				ArrayList<ArrayList<Integer>> neib = adj.get(u);
				for (ArrayList<Integer> list : neib) {
					int vertex = list.get(0);
					int wt = list.get(1);
					if (ans[vertex] > ans[u] + wt) {
						ans[vertex] = ans[u] + wt;
						q.add(new pair(vertex, ans[vertex]));

					}
				}
			}
		}
		return ans;
	}
}
