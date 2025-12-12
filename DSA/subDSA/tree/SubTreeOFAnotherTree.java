package tree;

public class SubTreeOFAnotherTree {
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
		if(root==null)
			return false;
		
		if(isTreeEqal(root, subRoot))
			return true;
		
		
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		
    }
	
	public static boolean isTreeEqal(TreeNode root, TreeNode subRoot) {
		
		if(root==null && subRoot==null)
			return true;
		
		if((root==null && subRoot!=null) || (root!=null && subRoot==null))
			return false;
		
		
		if(root.val == subRoot.val){
			return isTreeEqal(root.left, subRoot.left) && isTreeEqal(root.right, subRoot.right);
		}
		
		return false;
		
	}
	
	class TreeNode {
	    int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


