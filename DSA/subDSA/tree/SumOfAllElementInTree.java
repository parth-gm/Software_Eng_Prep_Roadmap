package tree;

import tree.ExtractLeavesOfTree.TreeNode;

public class SumOfAllElementInTree {

	public static int sum(TreeNode head) {
		
		if(head==null)
			return 0;
		
		
		return head.val + sum(head.left) + sum(head.right);
		
	}
	
	public static void main(String[] args) {

		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		TreeNode subhead = new TreeNode(2, left, right);
		TreeNode subhead2 = new TreeNode(3, null, new TreeNode(7));
		TreeNode head = new TreeNode(1, subhead, subhead2);
		System.out.println(sum(head));
	}

}
