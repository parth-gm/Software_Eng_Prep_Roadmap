package Ch04_Trees_Graphs;

import java.util.ArrayList;

public class CheckBalanced_Main {

	
	public static int heightv1(TreeNode tn) {
		if(tn==null)
			return -1;
		return 1+Math.max(heightv1(tn.left), heightv1(tn.right));
	}
	
	
	public static boolean isbalanced(TreeNode root) {
		if(root==null)
			return true;
		int diff=Math.abs(heightv1(root.left)-heightv1(root.right));
		if(diff>1)
			return false;
		else
			return isbalanced(root.left) && isbalanced(root.right);
	}
	
	public static void traverseTree(TreeNode root,ArrayList<Integer> arraytree) {
		
		if(root==null)
			return ;
		
		traverseTree(root.left,arraytree);
		
		int lefth=0,righth=0;
		
		if(root.left!=null)
			lefth=root.left.height();
		if(root.right!=null)
			righth=root.right.height();
		arraytree.add(Math.abs(lefth-righth));
		
		traverseTree(root.right,arraytree);
		
		
	}
	
	public static boolean checkBalanced(TreeNode root) {
		ArrayList<Integer> arraytree=new ArrayList<Integer>();
		traverseTree(root,arraytree);
		for(int i: arraytree) {
			//System.out.println(i);
			if(i>1) return false;
		}
		return true;
	}
	
	public static int checkHeightsV2(TreeNode root) {
		
		if(root==null)
			return -1;
		
		int leftHeight=checkHeightsV2(root.left);
		if(leftHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight=checkHeightsV2(root.right);
		if(rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int diff= Math.abs(leftHeight-rightHeight); 
		if(diff>1)
			return Integer.MIN_VALUE;
		else
			return 1+Math.max(checkHeightsV2(root.left),checkHeightsV2(root.right));
		
		
	}
	
	public static boolean checkBalancedV2(TreeNode root) {
		int h=checkHeightsV2(root);
		System.out.println(h);
		return h!=Integer.MIN_VALUE;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root=TreeNode.createMinimalBST(array);
//		TreeNode root=new TreeNode(5);
//		root.left=new TreeNode(3);
//		root.left.left=new TreeNode(2);
//		
		//System.out.println(root.height());
		System.out.println(checkBalancedV2(root));
		
	}
}
