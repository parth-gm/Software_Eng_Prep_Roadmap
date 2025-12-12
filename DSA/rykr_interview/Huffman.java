package roykar;

import java.util.PriorityQueue;

public class Huffman {

	public static void printHuffmanTree(HuffmanNode root, String s) 
	{
		   if(root.left==null && root.right==null){
	            System.out.println(root.data+": "+s);
	        }

	        if(root.left!=null){
	        	printHuffmanTree(root.left,s+"0");
	        }


	        if(root.right!=null){
	        	printHuffmanTree(root.right,s+"1");
	        }
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 6; 
	     char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
	     int[] charfreq = { 5, 9, 12, 13, 16, 45 };
	     
	     PriorityQueue<HuffmanNode> pqueue=new PriorityQueue<HuffmanNode>(n,new HuffmanComparator());
	     
	     for(int i=0;i<charArray.length;i++) {
	    	 pqueue.add(new HuffmanNode(charArray[i], charfreq[i]));
	     }
	     HuffmanNode root=null;
	     while(pqueue.size()>1) {
	    	 HuffmanNode x=pqueue.poll();
	    	 HuffmanNode y=pqueue.poll();
	    	 
	    	 HuffmanNode z=new HuffmanNode('-',x.freq+y.freq);
	    	 z.left=x;
	    	 z.right=y;
	    	 root=z;
	    	 pqueue.add(z);
	     }
	     printHuffmanTree(root, "");
	     
	}

}
