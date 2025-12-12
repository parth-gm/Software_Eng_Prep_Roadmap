package tree;

import tree.TreeSort.TreeNode;

public class IsTreeSymetric {
    public boolean isSymmetric(TreeNode root) {
        
        
        return utility(root.left, root.right);
        
    }
    
    public boolean utility(TreeNode lsub, TreeNode rsub){
        
        if(lsub==null || rsub==null)
            return lsub==rsub;
        
        if(lsub.val!=rsub.val)
            return false;
        
    
        return utility(lsub.left, rsub.right) && utility(lsub.right, rsub.left);
        
    }
    

	static class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
