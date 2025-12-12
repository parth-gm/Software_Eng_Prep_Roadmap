package roykar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	int treeSize;
	
	public Solution(int size) {
		this.treeSize=size;
	}

	
	public Node constructTreeHelper(String[] preorder,String[] inorder,int instart,int inend,int prestart,int preend) {
		if(instart>inend && prestart>preend )
			return null;
		
		
		String rootData=preorder[prestart];
		int rootindex=-1;
		for(int i=instart;i<=inend;i++) {
			if(rootData.equals(inorder[i])) {
				rootindex=i;
				break;
			}
		}
		int linstart=instart;
		int rinstart=rootindex+1;
		int linend=rootindex-1;
		int rinend=inend;
		int lprestart=prestart+1;
		int lpreend=lprestart+(linend-linstart);
		int rprestart=lpreend+1;
		int rpreend=preend;
		
		
		Node root=new Node(rootData);
		root.setleftChild(constructTreeHelper(preorder, inorder, linstart, linend, lprestart, lpreend));
		root.setrightChild(constructTreeHelper(preorder, inorder, rinstart, rinend, rprestart, rpreend));
		
		return root;
		
	}
	
	//construct tree using preorder and inorder traversal
	public Node constructTree(String[] preorder,String[] inorder) {
		return constructTreeHelper(preorder, inorder,0,inorder.length-1,0,preorder.length-1);
	}
	//main logic function
	public String[] printPattern(Node root) {
		
		//ArrayList<String> pattern=new ArrayList<String>();
		String[] pattern=new String[this.treeSize];
		int index=this.treeSize-1;
		if(root==null)
			return null;
		
		Queue<Node> queue=new LinkedList<Node>();
		
		queue.add(root);
		
		while(!queue.isEmpty() && index>=0) {
			
			Node front=queue.poll();
			//pattern.add(front.getValue());
			pattern[index--]=front.getValue();
			Node left=front.getLeft();
			Node right=front.getRight();
			
			if(left!=null)
				queue.add(left);
			if(right!=null)
				queue.add(right);
			
		}
		
		//Collections.reverse(pattern);
		return pattern;
		
	}
	public void printTree(Node root) {
		if(root==null)
			return;
		
		System.out.print(root.getValue() +": ");
		if(root.getLeft()!=null)
			System.out.print("left: "+ root.getLeft().getValue()+" ");
		
		if(root.getRight()!=null)
			System.out.print("right: "+root.getRight().getValue());
		
		System.out.println();
		
		
		printTree(root.getLeft());
		printTree(root.getRight());
		
	}
	
	public Node lowestCommonAncestor(Node root,int node1value,int node2value) {
		
		if(root==null)
			return root;
		
		
		int currentValue=Integer.parseInt(root.getValue());
		
		if(currentValue==node1value || currentValue==node2value)
			return root;
		
		
		if(currentValue<node1value && currentValue<node2value) {
			return lowestCommonAncestor(root.getRight(), node1value, node2value);
		}else if(currentValue>node1value && currentValue>node2value) {
			return lowestCommonAncestor(root.getLeft(), node1value, node2value);
		}
		return root;
		
		
		
	}
		
	
	
	public static int diameter(Node root) {
		
		if(root==null) {
			return 0;
		}
		
		int option1=height(root.getLeft())+height(root.getRight());
		int option2=diameter(root.getLeft());
		int option3=diameter(root.getRight());
		
		return Math.max(option1, Math.max(option2, option3));
		
		
	}
	
	public static Pair<Integer,Integer> heightDiameter(Node root){
		if(root==null) {
			return new Pair<Integer, Integer>(0,0);
		}
		
		Pair<Integer, Integer> lo=heightDiameter(root.getLeft());
		Pair<Integer, Integer> ro=heightDiameter(root.getRight());
		
		int height=1+Math.max(lo.first, ro.first);
		int option1=lo.first+ro.first;
		
		int option2=lo.second;
		int option3=ro.second;
		int diameter=Math.max(option1, Math.max(option2, option3));
		return new Pair<Integer, Integer>(height,diameter);
	}
	
	
	private static int height(Node root) {
		if(root==null)
			return 0;
		return 1+Math.max(height(root.getLeft()), height(root.getRight()));
	}


	public static void main(String[] args) {
		
		Solution tree=new Solution(6);

		
		String[] inorder= {"1","2","3","4","5","6","7"};
		String[] preorder= {"3","2","1","5","4","6","7"};
		
		
//		String[] inorder= {"C","B","D","A","F","E","G","H"};
//		String[] preorder= {"A","B","C","D","E","F","G","H"};
		Node root=tree.constructTree(preorder, inorder);
		//tree.printTree(root);
		
		System.out.println("diameter: "+diameter(root));
		System.out.println("Height-diameter: "+heightDiameter(root));
		
		
		Node ances=tree.lowestCommonAncestor(root, 4, 6);
		System.out.println("ancestor: "+ances.getValue());
		String[] pattern=tree.printPattern(root); //main logic function
			
		for(String out:pattern) {
			System.out.println(out);
		}
		
	}

}
