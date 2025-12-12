package Ch04_Trees_Graphs;

public class MinimalTree_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4};
		
		TreeNode root=TreeNode.createMinimalBST(array);
		System.out.println(root.isBST());
		System.out.println(root.height());
//		System.out.println("root-level 0: "+root.data+" root left: "+root.left.data+" root right: "+root.right.data);
//		
//		System.out.println(root.left.right.data+"  "+root.right.right.data);
//		

	}

}
