package Ch04_Trees_Graphs;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	private int size=0;
	int data;
	
	public TreeNode(TreeNode left,int data,TreeNode right) {
		this.left=left;
		this.right=right;
		this.data=data;
	}

	public TreeNode(TreeNode left,int data,TreeNode right,TreeNode parent) {
		this.left=left;
		this.right=right;
		this.data=data;
		this.parent=parent;
	}
	
	public TreeNode(int data) {
		this.left=null;
		this.right=null;
		this.parent=null;
		this.data=data;
	}
	
	private static TreeNode createMinimalBST(int start,int end,int arr[]) {
		if(end<start) return null;
		int mid=(start+end)/2;
		TreeNode n=new TreeNode(arr[mid]);
		n.left=createMinimalBST(start, mid-1, arr);
		n.right=createMinimalBST(mid+1, end, arr);
		return n;
	}
	
	public static TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(0, arr.length-1, arr);
	}
	
	public boolean isBST() {
		if(this.left!=null)
		{
			if(this.data<this.left.data)
				return false;
			else
				this.left.isBST();
		}
		
		if(this.right!=null) {
			if(this.data>this.right.data)
				return false;
			else
				this.right.isBST();
		}
		return true;
	}
	
	public int height() {
		int leftHeight=this.left!=null?this.left.height():0;
		int rightHeight=this.right!=null?this.right.height():0;
		return 1+Math.max(leftHeight, rightHeight);
	}


	public void insertInOrder(int d){
		if(d<this.data){
			if(this.left==null){
				this.left=new TreeNode(d);
			}else {
				this.left.insertInOrder(d);
			}
		}
		else{
			if(this.right==null){
				this.right=new TreeNode(d);
			}else {
				this.right.insertInOrder(d);
			}
		}
		this.size++;
	}

	public TreeNode find(int d){

		if(this.data==d){
			return  this;
		}
		else if(d<this.data){
			return this.left!=null?this.left.find(d): null;
		}else{
			return this.right!=null?this.right.find(d):null;
		}
	}


	public int getSize(){
		return this.size;
	}



}
