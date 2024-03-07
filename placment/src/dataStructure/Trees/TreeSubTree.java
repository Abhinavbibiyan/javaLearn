package dataStructure.Trees;
import java.util.*;

public class TreeSubTree {
	public static boolean isIdentical(Node tree,Node subTree) {
		if(tree==null && subTree==null ) return true;
		if(tree==null || subTree==null) return false;
		
		if(tree.data==subTree.data)
		{
		 	return isIdentical(tree.left,subTree.left)&& isIdentical(tree.right,subTree.right);
		}
		return false;
	}
	public static boolean subTree(Node tree,Node subTree) {
		if(subTree==null) return true;
		if(tree==null)  return false;
		if(subTree.data==tree.data) {
			if(isIdentical(tree,subTree)) {
				return true;
			}
		}
		return subTree(tree.left,subTree)||subTree(tree.right,subTree);
	}
	
	public static void main(String[] arg) {
		
		 
	}
}
 