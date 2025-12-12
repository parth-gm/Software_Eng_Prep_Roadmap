package tree;

public class TreeSort {

	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 1};
		TreeNode root = new TreeNode(arr[0]);
		for(int i=1;i<arr.length;i++) {
			createBinarySearchTree(root, arr[i]);
		}
		inOrder(root);
		
		
		

	}
	
	static void inOrder(TreeNode root) {
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.val + ", ");
		inOrder(root.right);
	}
	
	static TreeNode createBinarySearchTree(TreeNode root, int ival) {
		
		if(root==null){
			return new TreeNode(ival);
		}
		
		if(root.val<=ival) {
			root.right = createBinarySearchTree(root.right, ival);
		}else {
			root.left = createBinarySearchTree(root.left, ival);
		}
		
		return root;
		
	}
	
	static class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
