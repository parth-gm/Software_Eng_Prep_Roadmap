package tree;

import java.util.ArrayList;

import tree.VerticalTreePrint.TreeNode;

public class ExtractLeavesOfTree {
	
	ArrayList<ArrayList<Integer>> arrl = new ArrayList<>();
	
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
	
	
	void extractLeavesByLevel(TreeNode root, int height) {
		
		if(root==null)
			return;
		
		if((arrl.size()-1)<height) {
			arrl.add(new ArrayList<>());
		}
		arrl.get(height).add(root.val);
		
		extractLeavesByLevel(root.left, height+1);
		extractLeavesByLevel(root.right, height+1);
		
	}
	
	int extractLeavesByHeight(TreeNode root) {
		
		if(root==null)
			return -1;
		
		
		int leftH = extractLeavesByHeight(root.left);
		int rightH = extractLeavesByHeight(root.right);
		int fH = Math.max(leftH, rightH) + 1;
		
		if((arrl.size()-1)<fH) {
			arrl.add(new ArrayList<>());
		}
		arrl.get(fH).add(root.val);
		
		return fH;
		
	}
	
	
	public static void main(String[] args) {
		
		
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		TreeNode subhead = new TreeNode(2, left, right);
		TreeNode subhead2 = new TreeNode(3, null, new TreeNode(7));
		TreeNode head = new TreeNode(1, subhead, subhead2);
		ExtractLeavesOfTree obj = new ExtractLeavesOfTree();
			
	}
//	tractLeavesByLevel(head, 0);
//		obj.extractLeavesByHeight(head);
//		System.out.println(obj.arrl);
//		
//		
//	}
	
}
