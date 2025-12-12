package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeZigZag {

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
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
//		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ls = new ArrayList<>();
		
//		List<Integer> ls = new ArrayList<Integer>();
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		int level = -1;
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			if(!s1.isEmpty()) {
				ls.add(new ArrayList<>());
				level++;
			}
			while(!s1.isEmpty()) {
				
				TreeNode currNode = s1.pop();
				ls.get(level).add(currNode.val);
				if(currNode.left!=null)
					s2.add(currNode.left);
				
				if(currNode.right!=null)
					s2.add(currNode.right);
				
			}
			if(!s2.isEmpty()) {
				ls.add(new ArrayList<>());
				level++;
			}
			
			while(!s2.isEmpty()) {
				
				TreeNode currNode = s2.pop();
				ls.get(level).add(currNode.val);
				
				if(currNode.right!=null)
					s1.add(currNode.right);
				
				if(currNode.left!=null)
					s1.add(currNode.left);
				
				
			}
			
			
		}
		System.out.println(ls);
		return null;
		
    }
	
	public static void main(String[] args) {

		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		TreeNode subhead = new TreeNode(2, left, right);
		TreeNode subhead2 = new TreeNode(3, null, new TreeNode(7));
		TreeNode head = new TreeNode(1, subhead, subhead2);
		zigzagLevelOrder(head);
		
	}

}
