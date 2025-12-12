package Ch04_Trees_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepth {
	
	public static boolean searchBFSv2(Graph g, Node start, Node end) {
		Queue<Node> queue=new LinkedList<Node>();
		
		for(Node n:g.getVertices())
			n.state=State.Unvisited;
		
		start.state=State.Visited;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node r=queue.poll();
			
			for(Node n: r.childrens) {
				if(n.state==State.Unvisited) {
					if(n==end) return true;
					n.state=State.Visited;
					queue.add(n);
				}
			}
			
		}
		return false;
		
	}
	
	public static ArrayList<LinkedList<TreeNode>> createListofDepth(TreeNode root){
		ArrayList<LinkedList<TreeNode>> arrayOfList= new ArrayList<LinkedList<TreeNode>>();
		
		
		LinkedList<TreeNode> current=new LinkedList<TreeNode>();
		
		if (root!=null)
			current.add(root);
		
		while(!current.isEmpty()) {
			arrayOfList.add(current);
			LinkedList<TreeNode> parents=current;
			current=new LinkedList<TreeNode>();
			for(TreeNode parent:parents) {
				if(parent.left!=null)
					current.add(parent.left);
				if(parent.right!=null)
					current.add(parent.right);
			}
			
		}

		return arrayOfList;
	}

	static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,int level) {
		if(root == null) return;
		
		LinkedList<TreeNode> list =null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else {
			list=lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left,lists,level+1);
		createLevelLinkedList(root.right, lists, level+1);
	}
	
	
	static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists= new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = TreeNode.createMinimalBST(array);
//		ArrayList<LinkedList<TreeNode>> listoflevels=createListofDepth(root);
		ArrayList<LinkedList<TreeNode>> listoflevels= createLevelLinkedList(root);
		for(LinkedList<TreeNode> lt:listoflevels) {
			for(TreeNode t:lt)System.out.print(t.data+" ");
			System.out.println();
		}
		
		
	}

}
