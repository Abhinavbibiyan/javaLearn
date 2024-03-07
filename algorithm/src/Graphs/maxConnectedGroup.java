package Graphs;

import java.util.*;
class disjointSize {
	int n;
	int parent[];
	int size[];

	disjointSize(int n) {
		this.n = n;
		parent = new int[n + 1];
		size = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public int find(int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}

	public void union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (pv == pu)
			return;
		if (size[pu] < size[pv]) {
			parent[pu] = pv;
			size[pv] += size[pu];
		} else {
			parent[pv] = pu;
			size[pu] += size[pv];
		}
	}
}

public class maxConnectedGroup {
	
	public static boolean isValid(int r, int c, int n, int m) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	public static int MaxConnection(int grid[][]) {
	        //Your code here
	        int max=0;
	        int n=grid.length;
	        int m=grid[0].length;
	        disjointSize dis=new disjointSize(n*m);
	        for(int row=0;row<n;row++){
	            for(int col=0;col<m;col++){
	                if(grid[row][col]==0) continue;
	                int drow[]={-1,0,1,0};
	                int dcol[]={0,-1,0,1};
	                for(int i=0;i<4;i++){
	                    int newr=row+drow[i];
	                    int newc=col+dcol[i];
	                    if(isValid(newr,newc,n,m) && grid[newr][newc]==1){
	                        int node=row*m+col;
	                        int adjNode=newr*m+newc;
	                        dis.union(node,adjNode);
	                    }
	                }
	            }
	        }
	        
	        for(int row=0;row<n;row++){
	            for(int col=0;col<m;col++){
	                if(grid[row][col]==1) continue;
	                int drow[]={-1,0,1,0};
	                int dcol[]={0,1,0,-1};
	                HashSet<Integer> s=new HashSet<>();
	                for(int i=0;i<4;i++){
	                    int newr=row+drow[i];
	                    int newc=col+dcol[i];
	                    if(isValid(newr,newc,n,m) && grid[newr][newc]==1){
	                        int adjNode=newr*m+newc;
	                        int parent=dis.find(adjNode);
	                        s.add(parent);
	                    }
	                }
	                int maxlen=0;
	                for(Integer par:s){
	                    maxlen+=dis.size[par];
	                }
	                max=Math.max(max,1+maxlen);
	            }
	        }
	        for(int i=0;i<n*m;i++){
	            max=Math.max(max,dis.size[dis.find(i)]);
	        }
	        return max;
	    }  
	public static void main (String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };
        int ans=MaxConnection(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }
}
