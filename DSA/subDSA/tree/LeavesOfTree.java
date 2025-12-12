package tree;

import java.util.ArrayList;

public class LeavesOfTree {

	static void getLeavesofTree(TreeNode head, ArrayList<ArrayList<Integer>> list, int curHeight) {
		
		if(head==null)
			return;
		
//		if(head.left==null && head.right==null)
//		{
//			list.add(head.val);
//			return;
//		}
//		
		getLeavesofTree(head.left, list, curHeight+1);
		list.get(curHeight).add(head.val);
		getLeavesofTree(head.right, list, curHeight+1);
		
		
		
		
	}

	static class TreeNode {
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
		
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		TreeNode subhead = new TreeNode(2, left, right);
		TreeNode subhead2 = new TreeNode(3, null, new TreeNode(7));
		TreeNode head = new TreeNode(1, subhead, subhead2);
		ArrayList<ArrayList<Integer>> arrl = new ArrayList<ArrayList<Integer>>();
		int counter = 5;
		while(counter-->0) {
			arrl.add(new ArrayList<Integer>());
		}
		TreeNode cur = head;
		ArrayList<Integer> arrl1 = new ArrayList<Integer>();
//		while(cur!=null) {
			getLeavesofTree(head, arrl, 0);
			System.out.println(arrl);
			
//		}
	}

}


