package trie;

import java.awt.geom.CubicCurve2D;

public class MaxXOR{
	public static class TrieNode {
		
		TrieNode left, right;
		
		
		
		
	}
	
	public void insert(int n, TrieNode head) {
		
		TrieNode curr = head;
		for(int i=31;i>=0;i--) {
			
			int b = (n>>i)&1;
			if(b==0) {
				
				if(curr.left==null) {
					curr.left = new TrieNode();
				}
				curr = curr.left;
			}else {
				if(curr.right==null) {
					curr.right = new TrieNode();
				}
				curr = curr.right;
			
			}
		}

	}
	//Nlog(Max ele in arr)
	public int findMaxXOR(TrieNode head, int[] arr) {
		
		int maxXor = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			int value = arr[i];
			TrieNode curr = head;
			int curXor = 0;
			for(int j=31;j>=0;j--) {
				
				int b = (value>>j)&1;
				if(b==0) {
					//right
					if(curr.right!=null) {
						curXor += Math.pow(2, j);
						curr = curr.right;
					}else {
						curr = curr.left;
					}
					
				}else {
					
					if(curr.left!=null) {
						curr = curr.left;
						curXor += Math.pow(2, j);
					}else {
						curr = curr.right;
					}
					
				}
				
			}
			maxXor = Math.max(maxXor, curXor);
				
			
			
			
		}
		return maxXor;
		
		
	}
	
	public static void main(String[] args) {
		MaxXOR mx = new MaxXOR();
		TrieNode root = new TrieNode();
		int[] arr = {8, 1, 2, 15, 10, 5};
		for(int i=0;i<arr.length;i++) {
			mx.insert(arr[i], root);
		}
		System.out.println(mx.findMaxXOR(root, arr));
		char c = 97;
		System.out.println((char)(1+c));
		StringBuffer sb = new StringBuffer();
		sb.append((char)(1+c));
		System.out.println(sb.toString());
	}

}

