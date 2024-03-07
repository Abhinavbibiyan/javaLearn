package dataStructure.Trees;
import java.util.*;

import dataStructure.Trees.binarySearchTree.Node;
class tNode{
	int data;
	tNode left;
	tNode right;  
	tNode(int data){
		this.data=data;
	}
}
class pair{
	tNode node;
	int val;
	pair(tNode node,int val){
		this.node=node;
		this.val=val;
	}
}
public class allInOneTra {	
	public static tNode insert(tNode root,int val) {
		if(root==null) {
			root=new tNode(val);
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
	public static void preInPos(tNode root) {
		
		ArrayList<Integer> pre=new ArrayList<>();
		ArrayList<Integer> In=new ArrayList<>();
		ArrayList<Integer> pos=new ArrayList<>();
		
		Stack<pair> q=new Stack<>();
		q.add(new pair(root,1));
		
		if(root==null) return ;
		
		while(!q.isEmpty()) {
			pair curr=q.pop();
//			int num=curr.val;
			if(curr.val==1) {
				pre.add(curr.node.data);
				curr.val++;
				q.add(curr);
				if(curr.node.left!=null) {
					q.add(new pair(curr.node.left,1));
				}
			}
			else if(curr.val==2) {
				In.add(curr.node.data);
				curr.val++;
				q.add(curr);
				if(curr.node.right!=null) {
					q.add(new pair(curr.node.right,1));
				}
			}
			else {
				pos.add(curr.node.data);
			}
		}
		System.out.println(pre);
		System.out.println(In);
		System.out.println(pos);
	}
	public static void inorder(tNode root) {
		if(root==null) {
			return ;
		}
		
		inorder(root.left);
		
		inorder(root.right);
		System.out.print(root.data+ "  ");
	}
	public static void main(String[] args) {
		int value[]= {8,5,3,1,4,6,10,11,14};
		tNode root=null;
		for(int i=0;i<value.length;i++) {
			root=insert(root,value[i]);
		} 
		preInPos(root);
		inorder(root);
		
	}
}
