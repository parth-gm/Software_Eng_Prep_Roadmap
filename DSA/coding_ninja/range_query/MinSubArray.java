package range_query1;

import java.util.Arrays;
import java.util.Scanner;

public class MinSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nq = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] tree = new int[n*4];
		
		buildTree(arr, tree, 0, n-1, 1);
		System.out.println(Arrays.toString(tree));
		for(int i=0;i<nq;i++) {
			char c = sc.next().charAt(0);
			if(c=='q') {
				int left = sc.nextInt();
				int right = sc.nextInt();
				int ans = query(tree, 0, n-1, 1, left-1, right-1);
				System.out.println(ans);
			}else {
				int index = sc.nextInt();
				int B = sc.nextInt();
				updateTree(arr, tree, 0, n-1, 1, index-1, B);
			}
			
		}
		
	}
	
	static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
		
		if(start==end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start + end )/2;
		
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1) ;
		
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
				
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
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
		
		
	}

	static int query(int[] tree, int start, int end, int treeNode, int left, int right) {
		System.out.println(start+","+end+","+left+","+right);
		if(left>end || right<start) {
			return Integer.MAX_VALUE;
		}
		else if(start>=left	 && end<=right) {
			return tree[treeNode];
		}
		else {
			int mid = (start+end)/2;
			int ans1 = query(tree, start, mid, 2*treeNode, left, right) ;  
			int ans2 = query(tree, mid+1, end, 2*treeNode+1, left, right);
			return Math.min(ans1, ans2);
			
		}
		
		
	}
}
