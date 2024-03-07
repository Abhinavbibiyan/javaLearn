package dataStructure.Trees;

import java.util.*;
import java.util.Collections;
import java.util.Stack;

public class binarySearchTree {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	
public static Node insert(Node root,int val) {
		if(root==null) {
			root=new Node(val);
			return root;
		}
		if(root.data>val) {
			root.left=insert(root.left,val);
		}
		else {
			root.right=insert(root.right,val);
		}
		return root;
	}

     public static void ZigZak(Node root) {
    	 if(root==null)
    		 return;
    	 Stack<Node> currLevel=new Stack<>();
    	 Stack<Node> nextLevel=new Stack<>();
    	 boolean leftToRight=true;
    	 currLevel.push(root);
    	 
    	 while(!currLevel.isEmpty()){
    		 Node curr=currLevel.pop();
    		 if(curr!=null) {
    			 System.out.print(curr.data+" -> ");
    		 
    		 if(leftToRight==true) {
    			 if(curr.left!=null) {
    				 nextLevel.push(curr.left);
    			 }
    			 if(curr.right!=null) {
    				 nextLevel.push(curr.right);
    			 }
    		 }else {
    			 if(curr.right!=null) {
    				 nextLevel.push(curr.right);
    			 }
    			 if(curr.left!=null) {
    				 nextLevel.push(curr.left);
    			 }
    		 }
    		 
        }
    		 
    		 if(currLevel.isEmpty()) {
        		 leftToRight=!leftToRight;
        		 //swap(currLevel,nextLevel);
        		 Stack<Node> temp=currLevel;
        			currLevel=nextLevel;
        			nextLevel=temp;
    	 }
     }
}

	public static void swap(Stack<Node> currLevel, Stack<Node> nextLevel) {
		Stack<Node> temp=currLevel;
		currLevel=nextLevel;
		nextLevel=temp;
	}
	public static void levelOrder(Node root) {
		if(root==null)
			return ;
		Queue<Node>Q=new LinkedList<>();
		Q.add(root);
		Q.add(null);
		while(!Q.isEmpty()) {
			Node currNode=Q.poll();
			if(currNode==null) {
				System.out.println();
				if (Q.isEmpty()) {
					break;

				} else {
					Q.add(null);

				}
			} else {
				System.out.print(currNode.data + "  ");
				if (currNode.left != null) {
					Q.add(currNode.left);
				}
				if (currNode.right != null) {
					Q.add(currNode.right);
				}
			
			}
		}
	}

	public static boolean isBST(Node root,Node min,Node max) {
		if(root==null) return true;
		if(min!=null && root.data<=min.data) return false;
		if(max!=null && root.data>=max.data) return false;
		boolean leftValid =isBST(root.left,min,root);
		boolean rightValid=isBST(root.right,root,max);
		return leftValid && rightValid;
 
	}
	public static void inorder(Node root) {
		if(root==null) {
			return ;
		}
		inorder(root.left);
		System.out.print(root.data+ "  ");
		inorder(root.right);
	}
	public static boolean search(Node root,int key) {
	   if(root==null) {
		   return false;
	   }
	   if(root.data>key) {
		  return search(root.left,key);
		   
	   }
	  
	   else if(root.data==key) {
		   return true;
	   }
	   else   {
		   return search(root.right,key);
	   }
		   
	
	}
	public static Node delete(Node root,int val) {
		if(root.data>val) {
			root.left=delete(root.left,val);
		}
		else if(root.data<val){
			root.right=delete(root.right,val);
		  }
		else{
		    // Case 1
			if(root.left==null && root.right==null) {
				return null;
			}
			//case 2
			if(root.left==null) {
				return root.right;
			}		
			else if(root.right==null) {
				return root.left;
			}
		     
		//case 3
		    Node Is= inorderSuccessor(root.right);
			root.data=Is.data;
			root.right=delete(root.right,Is.data);
			
		}
		return root;
	}
	public static Node inorderSuccessor(Node root) {
		while(root!=null && root.left!=null) {
			root=root.left;
		}
		return root;
	}
	public static void printInRange(Node root,int X,int Y) {
		if(root==null) {
			return ;
			
		}
		if((root.data>=X) && (root.data<=Y)) {
			printInRange(root.left,X,Y);
			System.out.print(root.data+"  ");
			printInRange(root.right,X,Y);
			
		}else if(root.data>=Y) {
			printInRange(root.left,X,Y);
		}
		else
			printInRange(root.right,X,Y);
	}
	public static void PrintPath(ArrayList<Integer>path) {
		for(int i=0;i<path.size();i++) {
			System.out.print(path.get(i)+ " -> ");
		}
		System.out.println("null");
	}
	public static void printRoot2Leaf(Node root,ArrayList<Integer> path) {
		if(root==null) return ;
	
	path.add(root.data);
	if(root.left==null&& root.right==null) {
		PrintPath(path);
	}else {    //non leaf path
	printRoot2Leaf(root.left,  path);
	printRoot2Leaf( root.right, path);
		}
	path.remove(path.size()-1);
	}	
	public static void main(String arg[]) {
		int value[]= {8,5,3,1,4,6,10,11,14};
		int element[]=  {8,13,3, 4,  11, 12,5,14, 15,16,18,20, 1 ,2,9 };
	    
		Node root=null;
		for(int i=0;i<value.length;i++) {
			root=insert(root,value[i]);
		}
		
		Node node=null;
		for(int i=0;i<element.length;i++) {
			node=insert(node,element[i]);
		}
		 
		inorder(root);
		System.out.println();
		System.out.println("\n"+search(root,5));
	    delete(root,4);
	    inorder(root);
	    System.out.println();
	    delete(root,10);
	    inorder(root);
	    System.out.println();
	    delete(root,5);
	    levelOrder(root);
	    System.out.println();
	    
	 	printInRange(root,4,10);
		Node Root=new Node(3);
		Root.left=new Node(1);
		Root.right=new Node(2);

		ArrayList<Integer> path=new ArrayList<>();
		printRoot2Leaf(root,path);
		printRoot2Leaf(root,new ArrayList<Integer>());
		System.out.println(isBST(root,null,null));
	    ZigZak(root);
	    inorder(root);
	   
	    System.out.println();
	    levelOrder(node);
	    System.out.println();
	    ZigZak(node);
	    System.out.println();
	    inorder(node);
	 System.out.println("\n"+isBST(node,null,null));
	}
}
