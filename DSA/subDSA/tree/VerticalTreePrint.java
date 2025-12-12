package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import tree.LeavesOfTree.TreeNode;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalTreePrint {
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
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
        
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		buildMapUsingDFS(root, 0, 0, map);
		System.out.println(map);
		for(Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
			list.add(new ArrayList<>());
			for(Entry<Integer, PriorityQueue<Integer>> sentry: entry.getValue().entrySet()) {
				PriorityQueue<Integer> pq = sentry.getValue();
				while(!pq.isEmpty())
					list.get(list.size()-1).add(pq.poll());
			}
			System.out.println();
		}
		System.out.println(list);
		return list;
		
		
    }
	
	
	private static void buildMapUsingDFS(TreeNode root, int y, int x, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
		if(root==null) {
			return;
		}
		
		if(!map.containsKey(y)) {
			map.put(y, new TreeMap<>());
		}
		
		if(!map.get(y).containsKey(x)) {
			map.get(y).put(x, new PriorityQueue<>());
		}
		map.get(y).get(x).add(root.val);
		
		
		buildMapUsingDFS(root.left, y-1, x+1, map);
		buildMapUsingDFS(root.right, y+1, x+1, map);
		
		
	}


	public static void main(String[] args) {
		
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		TreeNode subhead = new TreeNode(2, left, right);
		TreeNode subhead2 = new TreeNode(3, null, new TreeNode(7));
		TreeNode head = new TreeNode(1, subhead, null);
		verticalTraversal(head);
		
	}

}

