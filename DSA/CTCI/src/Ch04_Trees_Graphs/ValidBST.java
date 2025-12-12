package Ch04_Trees_Graphs;

import java.util.ArrayList;

public class ValidBST {

	public static boolean checkBST(TreeNode root) {
		if(root==null) {
			return true;
		}
		
		int leftdata=0,rightdata=0;
		
		if(root.left==null)
			leftdata=Integer.MIN_VALUE;
		else
			leftdata=root.left.data;
		
		if(root.right==null)
			rightdata=Integer.MAX_VALUE;
		else
			rightdata=root.right.data;
		
		
		if(root.data<leftdata || root.data>rightdata)
			return false;
		else
			return checkBST(root.left) && checkBST(root.right);
		
	}
	
	public static void checkBSTInorder(TreeNode root,ArrayList<Integer> al) {
		
		if(root==null) return ;
		
		checkBSTInorder(root.left, al);
		al.add(root.data);
		checkBSTInorder(root.right, al);
	}
	
	static boolean checkBSTV2(TreeNode root){
		ArrayList<Integer> al=new ArrayList<Integer>();
		checkBSTInorder(root, al);
		int prev=al.get(0);
		for(int i=1;i<al.size();i++) {
			if(al.get(i)<=prev)
				return false;
			prev=al.get(i);
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root=TreeNode.createMinimalBST(array);
//		TreeNode root=new TreeNode(5);
//		root.left=new TreeNode(3);
//		root.left.left=new TreeNode(2);
//		root.left.right=new TreeNode(10);
//		//System.out.println(checkBSTV2(root));
		
		System.out.println(checkBSTV2(root));
		

	}

}
