package Graphs;
import java.util.*;

class triples{
	 int src, des, time;
	 triples(int src, int des, int time){ 
		 this.des=des;
		 this.src=src;
		 this.time=time;
	 }
}
public class rottenOrange {

	public static int rottenTime(int grid[][]) {
		int time=0;
		int fresh=0;
		int n=grid.length;
		int m=grid[0].length;
		
		int[][] vis=new int[n][m];
		Queue<triples> q=new LinkedList<>();
		
		for(int i =0;i< n; i++) {
			for(int j=0;j<m;j++) {
				
				if(grid[i][j]==2) {
					q.add(new triples(i,j,0));
					vis[i][j]=2;
				}else
					vis[i][j]=0;
				if(grid[i][j]==1) fresh++;
				
			}
		}
		int cnt=0;
		int[] dRow= {-1,0,1,0};
		int[] dCol= {0,1,0,-1};
		
		while(!q.isEmpty()) {
			
			triples cur=q.poll();
			int r=cur.src;
			int c=cur.des;
			int t=cur.time;
			time=Math.max(time, t);
			for(int i=0;i<4;i++) {
				
				int newRow=r + dRow[i];
				int newCol=c + dCol[i];
				
				if(newRow>=0 && newRow <n && newCol>=0 && newCol <m
						&& vis[newRow][newCol]==0 && grid[newRow][newCol]==1) {
					q.add(new triples(newRow,newCol,t+1));
					 
					vis[newRow][newCol]=2;
					cnt++;
					
				}
			}
			
		}
		
		if(cnt!=fresh) return -1;
		
		return time;
	}
	public static void main(String[] args)
	    {
	        int v[][] =    {{2, 1, 0, 2, 1},
	        				{1, 0, 1, 2, 1},
	        				{1, 0, 0, 2, 1}};      		 
	        System.out.println("Max time incurred: "
	                           + rottenTime(v));
	    
		
	}
	
}
