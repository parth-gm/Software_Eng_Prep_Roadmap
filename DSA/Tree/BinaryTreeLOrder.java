package july2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLOrder {

public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        
	
	ArrayList<List<Integer>> arrl=new ArrayList();
	
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	
	queue.add(root);
	ArrayList<Integer>rootlevel=new ArrayList<Integer>();
	rootlevel.add(root.val);
	arrl.add(rootlevel);
	while(!queue.isEmpty()) {
		
		int nodeCount=queue.size();
		ArrayList<Integer>currentlevel=new ArrayList<Integer>();
		while(nodeCount>0)
		{
			TreeNode current=queue.remove();
			if(current.left!=null) {
				queue.add(current.left);
				currentlevel.add(current.left.val);
			}
			
			if(current.right!=null) {
				queue.add(current.right);
				currentlevel.add(current.right.val);
			}
			nodeCount--;
		}
		if(currentlevel.size()>0)
			arrl.add(currentlevel);
	}
	
	Collections.reverse(arrl);
	return arrl;
        
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=new TreeNode(3);
		
		root.left=new TreeNode(4);
		root.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		
		List<List<Integer>> arrl=levelOrderBottom(root);
		
		for(List<Integer> ar:arrl) {
			System.out.println(ar.toString());
		}
	
	}

}
