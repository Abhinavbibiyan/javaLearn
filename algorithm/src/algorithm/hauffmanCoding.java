package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class hauffmanCoding {
	class Node {
	    int data;
	    Node left,right;
	    public Node(int data){
	        this.data=data;
	        this.left=null;
	        this.right=null;
	    }
	                // for descending order of cgpa
	            // public int compare(Student s1, Student s2) {
	            //     if (s1.cgpa < s2.cgpa)
	            //         return 1;
	            //     else if (s1.cgpa > s2.cgpa)
	            //         return -1;
	            //                     return 0;
	            //     }
	        
	   // @override
//	      @Override
//	     public int compare(Node a,Node b) {
//	 				// TODO Auto-generated method stub
//	 			//	return this.data-b.data;
//	 			if(a.data>b.data){
//	 			    return 1;
//	 			}else{
//	 			    return -1;
//	 			}
					 
				
//	     }
	    
	}
	class NodeComparator implements Comparator<Node>{
	             
	            // Overriding compare()method of Comparator
	                        // for descending order of cgpa
	            public int compare(Node a,Node b) {
	                if (a.data < b.data)
	                    return 1;
	                else if (a.data>b.data)
	                    return -1;
	                                return 0;
	                }
	        }
	 
 
	    
	    public static void traverse(Node root,ArrayList<String>ans,String temp){
	        
	        if(root.left==null && root.right==null){
	            ans.add(ans.size()-1,temp);
	            return;
	        }
	        
	        traverse(root.left,ans,temp+'0');
	        traverse(root.right,ans,temp+'1');
	        
	    }
	    
	    public ArrayList<String> huffmanCodes(String S, int f[], int N)
	    {
	        // Code here
	        PriorityQueue<Node>pq=new PriorityQueue<>(new NodeComparator());
	        for(int i=0;i<N;i++){
	            Node newNode=new Node(f[i]);
	            pq.add(newNode);
	 
	        }
	        
	        while(!pq.isEmpty()){
	            Node left=pq.poll();
	            Node right=pq.poll();
	            Node newNode=new Node(left.data+right.data);
	            newNode.left=left;
	            newNode.right=right;
	            pq.add(newNode);
	        }
	        
	        Node root=pq.peek();
	        
	        ArrayList<String>ans=new ArrayList<>();
	        String temp="";
	        traverse(root,ans,temp);
	        return ans;
	        
	        
	    }
	}

