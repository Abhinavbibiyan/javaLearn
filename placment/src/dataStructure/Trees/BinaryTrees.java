package dataStructure.Trees;
 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class BinaryTrees {

	static int Lht = 0, Rht = 0;

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}
		

	

	
	public static class BinaryTree {
	static	Node first,mid,last,prev;
		static int idx = -1;
		public class infoBST{
			int subMax,subMin,size,ans;
			boolean isBST;
			infoBST(int subMax,int subMin,int size,int ans,boolean isBST){
				this.subMax=subMax;
				this.subMin=subMin;
				this.size=size;
				this.ans=ans;
				this.isBST=isBST;
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
	
		public infoBST largestBSTinBT(Node root) {
			if(root==null) {
				return new infoBST(Integer.MIN_VALUE,Integer.MAX_VALUE,0,0,true);
			}
			if(root.left==null && root.right==null ) {
				return new infoBST(root.data,root.data,1,1,true);
		 }
			infoBST leftInfo=largestBSTinBT(root.left);
			infoBST rightInfo=largestBSTinBT(root.right);
			infoBST curr =new infoBST(0,0,0,0,true);
			curr.size=1+leftInfo.size+rightInfo.size;
			if(leftInfo.isBST && rightInfo.isBST && leftInfo.subMax<root.data && rightInfo.subMin>root.data) {
				curr.subMax=Math.max(rightInfo.subMax,Math.max(root.data, leftInfo.subMax));
				curr.subMin=Math.min(leftInfo.subMin, Math.min(root.data, rightInfo.subMin));
				curr.isBST=true;
				curr.ans=curr.size;
				return curr;
			}
			curr.ans=Math.max(leftInfo.ans,rightInfo.ans);
			curr.isBST=false;
			return curr;
					
		}
		
		
		
		//@SuppressWarnings("unused")
		public static void restorBST(Node root) {
			
			 first= mid = last= prev =null;
			calcPointer(root);
			if(first!=null && last!= null) {
				 int temp=first.data;
				 first.data=last.data;
				 last.data=temp;
			}
			else if(first!=null && mid!=null){
				int var=first.data;
				first.data=mid.data;
				mid.data=var;
			}
		}
		public static void calcPointer(Node root) {
			if(root == null) return;
			calcPointer(root.left);
			if(prev!=null && root.data<prev.data) {
				if(first==null) {
					
				
				first=prev;
				mid=root;
				
			}
			else {
				last=root;
			}
			}
			prev=root;
			calcPointer(root.right);
		}
	 
		
		
		public static void treeFlat(Node root) {
			 
			if(root==null||( root.left==null && root.right==null )) return ;
			if(root.left!=null) {
				treeFlat(root.left);
				Node temp=root.right;
				root.right=root.left;
				root.left=null;
				Node t=root.right;
					t=t.right;
				while(t.right!=null) {
				}
				t.right=temp;
			}
			treeFlat(root.right);
		}

		public static Node buildtree(int Nodes[]) {
			idx++;
			if (Nodes[idx] == -1) {
				return null;
			}

			Node newNode = new Node(Nodes[idx]);
			newNode.left = buildtree(Nodes);
			newNode.right = buildtree(Nodes);
			return newNode;
		}

		public static void preorder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data + "  ");
			preorder(root.left);
			preorder(root.right);
		}

		public static void inorder(Node root) {
			if (root == null)
				return;
			inorder(root.left);
			System.out.print(root.data + "  ");
			inorder(root.right);
		}

		public static void postorder(Node root) {
			if (root == null)
				return;
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + "  ");
		}

		public static void levelOrder(Node root) {
			if (root == null) {
				return;
			}
			Queue<Node> Q = new LinkedList<>();
			Q.add(root);
			Q.add(null);
			while (!Q.isEmpty()) {
				Node currNode = Q.remove();
				if (currNode == null) {
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

		public static int height(Node root) {
			int Lheight, Rheight;
			if (root == null)
				return 0;
			Lheight = height(root.left);
			Rheight = height(root.right);
			return (Math.max(Lheight, Rheight)) + 1;
		}

		public static int findDistance(Node root, int n1, int dist) {
			if (root == null)
				return -1; 
			 
			if (root.data == n1)
				return dist;
			int left = findDistance(root.left, n1, dist + 1);
			if (left != -1)
				return left;
			else
				return findDistance(root.right, n1, dist + 1);

		}

		public static int sumNode(Node root) {

			int leftsum, rightsum;
			if (root == null) {
				return 0;
			}
			leftsum = sumNode(root.left);
			rightsum = sumNode(root.right);
			return leftsum + rightsum + root.data;
		}

		public static int countNode(Node root) {

			int count = 0;
			if (root == null) {
				return 0;

			}
			count = countNode(root.left) + countNode(root.right) + 1;
			return count;
		}

		public static void replaceSum(Node root) {
			if (root == null)
				return;
			replaceSum(root.left);
			replaceSum(root.right);
			if (root.left != null) {
				root.data += root.left.data;
			}
			if (root.right != null) {
				root.data += root.right.data;
			}
		}

		public static int Diameter(Node root, int heig) {
			if (root == null) {
				heig = 0;
				return 0;
			}

			int Ld = Diameter(root.left, Lht);
			int Rd = Diameter(root.right, Rht);
			int currDiameter = Lht + Rht + 1;
			heig = Math.max(Lht, Rht) + 1;
			return Math.max(currDiameter, Math.max(Ld, Rd));

		}

		public static int distBTnode(Node root, int n1, int n2) {
			Node lca = LCA(root, n1, n2);
			int dist1 = findDistance(lca, n1, 0);
			int dist2 = findDistance(lca, n2, 0);
			return dist1 + dist2;
		}

		public static void rightview(Node root) {
			if (root == null)
				return;
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Node curr = q.poll();
					if (i == size - 1) {
						System.out.println(curr.data);
					}
					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}
				}
			}
		}

		public static void leftView(Node root) {
			if (root == null)
				return;
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Node curr = q.poll();
					if (i == 0) {
						System.out.println(curr.data);
					}
					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}
				}
			}

		}

		boolean isBalance(Node root) {
			if (root == null)
				return true;
			if (isBalance(root.left) == false) {
				return false;
			}

			if (isBalance(root.right) == false) {
				return false;
			}
			int Lh = height(root.left);
			int Rh = height(root.right);
			if (Math.abs(Lh - Rh) <= 1) {
				return true;
			} else
				return true;

		}

		public static int diameter(Node root) {

			if (root == null) {
				return 0;
			}
			int Ldiameter = diameter(root.left);
			int Rdiameter = diameter(root.right);
			int Ndiameter = height(root.left) + height(root.right) + 1;
			return Math.max(Ndiameter, Math.max(Rdiameter, Ldiameter));
		}

		public static class TreeInfo {
			int Ht;
			int Di;

			public TreeInfo(int Ht, int Di) {
				this.Ht = Ht;
				this.Di = Di;
			}
		}

		public static Node LCA(Node root, int n1, int n2) {
			if (root == null)
				return null;
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node leftAns = LCA(root.left, n1, n2);
			Node rightAns = LCA(root.right, n1, n2);
			if (leftAns != null && rightAns != null) {
				return root;
			}
			if (leftAns != null) 
				return leftAns;
			else
				return rightAns;
		}

		public static boolean getPath(Node root, int key, Vector<Integer> path) {
			if (root == null)
				return false;
			path.add(path.size(), root.data);
			;
			if (root.data == key) {
				return true;
			}
			if (getPath(root.left, key, path) || getPath(root.right, key, path)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
		}

		public static int LCE(Node root, int n1, int n2) {
			Vector<Integer> path1 = new Vector<>();
			Vector<Integer> path2 = new Vector<>();
			if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
				System.out.println("Path doesn't exist ");
				return -1;
			}
			int changePath;
			for (changePath = 0; changePath < path1.size() && changePath < path2.size(); changePath++) {
				if (path1.get(changePath) != path2.get(changePath)) {
					break;
				}
			}
			return path1.get(changePath - 1);
		}

		public static TreeInfo TreeDia(Node root) {
			if (root == null) {
				return new TreeInfo(0, 0);
			}
			TreeInfo left = TreeDia(root.left);
			TreeInfo right = TreeDia(root.right);
			int height = Math.max(left.Ht, right.Ht) + 1;
			int Ldia = left.Di;
			int Rdia = right.Di;
			int Ndia = left.Ht + right.Ht + 1;
			int diameter = Math.max(Math.max(Rdia, Ldia), Ndia);
			TreeInfo myInfo = new TreeInfo(height, diameter);
			return myInfo;
		}
	} 
	

	public static void main(String[] args) {
		int value[]= {6,7,2,1,3,5,4,8,9};
		int Nodes[] = { 6, 2, 7, 1, -1, -1, 3, -1, -1, 5, -1, -1, 7, 8,-1, -1, 9, -1, -1 };
		/*
			 		  1 
			  		/   \
			  	  2       6 
			     / \     /  \ 
			    4   5   3     7
			   / \
			  8   9
		 */
		int heig = 0;
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildtree(Nodes);

//		System.out.println(root.left.left.data);
// 		tree.preorder(root);
//		System.out.println();
//		tree.inorder(root);
//		System.out.println();
//		tree.postorder(root);
//		System.out.println();
//		tree.levelOrder(root);
//		System.out.println(); 
//		System.out.println("total node in tree is = " + tree.countNode(root));
//		System.out.println("total sum of the  tree is = " + tree.sumNode(root));
		System.out.println("height of tree is = " + tree.height(root));
//		System.out.println("diameter of tree is = " + tree.diameter(root));
//		System.out.println("diameter of tree is = " + tree.Diameter(root,he ig));
//		System.out.println("diameter of tree is = " + tree.TreeDia(root).Di);
//		tree.replaceSum(root);
//		tree.levelOrder(root);
// 		tree.rightview(root);
 		System.out.println();
// 		tree.leftView(root);
//		System.out.println(tree.LCE(root, 7, 6));
//		System.out.println(tree.LCA(root, 6, 7).data);
//		System.out.println(tree.distBTnode(root, 5, 7));
//		tree.treeFlat(root);
//		tree.inorder(root);
		//System.out.println(tree.isBST(root,null,null));
		Node node=null;
		for(int i=0;i<value.length;i++) {
			node=tree.insert(node,value[i]);
		}
//		
		/*				8
		 *            /   \
		 * 			5	    10
		 *         / \      / \
		 *        3   4        11 
		 *       / \             \
		 *      1                14
		 */
		System.out.println("\n");	
		tree.levelOrder(node);
		System.out.println();
//		Node n=new Node(15);
//		n.left=new Node(20);
//		n.right=new Node(30);
//		n.left.left=new Node(5);
//	    System.out.println(tree.largestBSTinBT(n).ans);
		tree.inorder(root);
		System.out.println();
		tree.restorBST(root);
		tree.inorder(root);
		System.out.println();
		tree.restorBST(root);
		tree.inorder(node
				);
		System.out.println();
		
	}
}

