package dataStructure.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import dataStructure.Trees.BinaryTrees.Node;

public class LevelSum {
	public static Scanner sc=new Scanner(System.in);
	public static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}  //public static class BinaryTree{
		
			static Node createTree() {
			Node root = null;
			System.out.println("Enter data: ");
			int data = sc.nextInt();

			if (data == -1)
				return null;

			root = new Node(data);

			System.out.println("Enter left for " + data);
			root.left = createTree();

			System.out.println("Enter right for " + data);
			root.right = createTree();

			return root;
		}
			public static void levelOrder(Node root) {
				if(root ==null) {
					return;
				}
				Queue<Node>Q=new LinkedList<>();
				Q.add(root);
				Q.add(null);
				while(!Q.isEmpty()) {
					Node currNode=Q.remove();
					if(currNode==null) {
						System.out.println();
						if(Q.isEmpty()) {
							break;
							
						}
						else {
							Q.add(null);
							
						}
					}else {
						System.out.print(currNode.data+"  ");
						if(currNode.left!=null) {
							Q.add(currNode.left);
						}
						if(currNode.right!=null) {
							Q.add(currNode.right);
						}
					}
				}
				
			}
			static int maxLevelSum(Node root)
			{
			     
			    // Base case
			    if (root == null)
			        return 0;
			 
			    // Initialize result
			    int result = root.data;
			 
			    // Do Level order traversal keeping
			    // track of number of nodes at every
			    // level.
			    Queue<Node> q = new LinkedList<>();
			    q.add(root);
			    while (!q.isEmpty())
			    {
			         
			        // Get the size of queue when the
			        // level order traversal for one
			        // level finishes
			        int count = q.size();
			 
			        // Iterate for all the nodes
			        // in the queue currently
			        int sum = 0;
			        while (count-- > 0)
			        {
			             
			            // Dequeue an node from queue
			            Node temp = q.poll();
			 
			            // Add this node's value
			            // to current sum.
			            sum = sum + temp.data;
			 
			            // Enqueue left and right children
			            // of dequeued node
			            if (temp.left != null)
			                q.add(temp.left);
			            if (temp.right != null)
			                q.add(temp.right);
			        }
			 
			        // Update the maximum node
			        // count value
			        result = Math.max(sum, result);
			    }
			    return result;
			}
			public static void levelSum(Node root,int k) {
				if(root ==null) {
					return;
				}
				Queue<Node>Q=new LinkedList<>();
				Q.add(root);
				Q.add(null);
				 int sum=0;
				int count =1;
				while(!Q.isEmpty()&& count<=k) {
					
					Node currNode=Q.remove();
					if(count==k && !(currNode.data==-1)) {
						sum+=currNode.data;
					}
					if(currNode==null) {
						System.out.println();
						if(Q.isEmpty()) {
							break;
							
						}
						else {
							Q.add(null);
							count++;
							
						}
					}else {
						//System.out.print(currNode.data+"  ");
						if(currNode.left!=null) {
							Q.add(currNode.left);
						}
						if(currNode.right!=null) {
							Q.add(currNode.right);
						}
					}
				}
				System.out.println("sum of Kth lavel is " + sum );
				
			}
				

	public static void main(String[] args) {
		Node tree= createTree();
		levelOrder(tree);
		//levelSum(tree,3);
		System.out.println(maxLevelSum(tree));
	    
	}

}
