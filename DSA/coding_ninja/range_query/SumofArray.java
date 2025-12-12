package range_query1;

import java.util.Arrays;

public class SumofArray {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] tree = new int[arr.length*2];
		
		buildTree(arr, tree, 0, 8, 1);
		updateTree(arr, tree, 0, 8, 1, 2, 10);
		System.out.println(Arrays.toString(tree));
		int ans = query(tree, 0, 8, 1, 2, 4);
		System.out.println(ans);
	}
	
	static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
		
		if(start==end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start + end )/2;
		
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1) ;
		
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
				
	}
	
	static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int idx, int value) {
		
		if(start==end) {
			arr[idx] = value;
			tree[treeNode] = value;
			return;
		}
		int mid = (start+end)/2;
		if(idx<=mid) {
			updateTree(arr, tree, start, mid, 2*treeNode, idx, value);
		}else {
			updateTree(arr, tree, mid+1, end, 2*treeNode+1, idx, value);
		}
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
		
		
	}

	static int query(int[] tree, int start, int end, int treeNode, int left, int right) {
		
		if(left>end || right<start) {
			return 0;
		}
		else if(left<=start && right>=end) {
			return tree[treeNode];
		}
		else {
			int mid = (start+end)/2;
			int ans1 = query(tree, start, mid, 2*treeNode, left, right) ;  
			int ans2 = query(tree, mid+1, end, 2*treeNode+1, left, right);
			return ans1 + ans2;
			
		}
		
		
	}
}
