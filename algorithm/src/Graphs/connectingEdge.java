package Graphs;

public class connectingEdge {
	class disjoint{
	    int n;
	    int parent[];
	    int rank[];
	    disjoint(int n){
	        this.n=n;
	        parent=new int[n+1];
	        rank=new int[n+1];
	        for(int i=0;i<=n;i++){
	            parent[i]=i;
	        }
	    }
	    public int find(int n){
	        if(parent[n]==n) return n;
	        return parent[n]=find(parent[n]);
	    }
	    public void union(int u,int v){
	        int pu=find(u);
	        int pv=find(v);
	        if(pu==pv) return;
	        else if(rank[pu]<rank[pv]) parent[pu]=pv;
	        else if(rank[pv]<rank[pu]) parent[pv]=pu;
	        else{
	            parent[pu]=pv;
	            rank[pv]++;
	        }
	    }
	}
	    public int Solve(int n, int[][] edge) {
	        // Code here
	        disjoint dis=new disjoint(n);
	        int cnt=0,extra=0;
	        for(int i=0;i<edge.length;i++){
	            
	                if(dis.find(edge[i][0])==dis.find(edge[i][1])){
	                    extra++;
	                }else{
	                    dis.union(edge[i][0],edge[i][1]);
	                }
	             
	        }
	        for(int i=0;i<n;i++){
	            if(dis.parent[i]==i) cnt++;
	        }
	        if(cnt-1<=extra) return cnt-1;
	        return -1;
	    }
}
