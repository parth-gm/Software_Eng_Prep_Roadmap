package graph;

public class LowestCommonAnsesctor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		
		if(root.val>p.val && root.val>q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}else if(root.val<p.val && root.val<q.val){
			return lowestCommonAncestor(root.right, p, q);
		}
		
		return root;
	
		
	}
	int ans = 0;
	public void kthSmallest(TreeNode root, int k){
	        
	    if(root==null)
	    	return;
		
	     kthSmallest(root.left, k);
	     k--;
	     if(k==0)
	    	 ans = root.val;
	     kthSmallest(root.right, k);
	     
	     
	     
	     
		 
	        
	        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
