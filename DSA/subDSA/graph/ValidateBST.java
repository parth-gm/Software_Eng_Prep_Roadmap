package graph;

public class ValidateBST {

	
	//Basic Resursion Approach will not work for [5, 3, 7, null, null, 4, 9]
	public static boolean isValidBST(TreeNode root) {
	    
		if(root==null)
			return true;
		
		if((root.left == null || root.left.val<root.val) && (root.right==null || root.right.val>root.val))
		{
			return isValidBST(root.left) && isValidBST(root.right);
		}
		
		
		return false;
		
		
	}
	//Using Range at every node
//	public static boolean isValidBST(TreeNode root) 
//	{
//		
//		
//		
//		
//	}	
	
	
	public static void main(String[] args) {
		

	}

}
