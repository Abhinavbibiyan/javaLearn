package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


	class G {
		 
	    // No. of vertices
	    private int V;
	 
	    // Array of lists for
	    // Adjacency List
	    // Representation
	    private LinkedList<Integer> adj[];
	 
	    @SuppressWarnings("unchecked") G(int v)
	    {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i = 0; i < v; ++i)
	            adj[i] = new LinkedList<>();
	    }
	 
	    // Method to add an edge into the graph
	    void addEdge(int v, int w)
	    {
	 
	        // Add w to v's list.
	        adj[v].add(w);
	    }
	    int ans=0;
	    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
	            int destination) {
	               
	                if(source==destination ){
	                  ans++;
	                }else{
	                   
	                Iterator<Integer> i=adj.get(source).listIterator();
	                while(i.hasNext()){
	                    int n=i.next();
	                    ans=countPaths(V,adj,n,destination);
	                    }
	                }
	        return ans;
	    }
	}

	    
	public class totalPath {
	    public static void main(String[] args){
	    	G g = new G(5);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(0, 3);
	        g.addEdge(1, 3);
	        g.addEdge(2, 3);
	        g.addEdge(1, 4);
	        g.addEdge(2, 4);
	 
	        int s = 0, d = 3;
	       
	          // Function call
	     //   System.out.println(g.countPaths(s, d));
	    }
	        
 }

