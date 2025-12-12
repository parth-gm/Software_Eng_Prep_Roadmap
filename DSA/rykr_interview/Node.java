package roykar;

import java.util.Scanner;

public class Node {

	private String value;
	private Node left;
	private Node right;
	
	public Node(String value) {
		this.value=value;
		this.left=null;
		this.right=null;
	}
	
	public Node(String value,Node left, Node right) {
		this.value=value;
		this.left=left;
		this.right=right;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setleftChild(Node left) {
		this.left=left;
	}
	
	public void setrightChild(Node right) {
		this.right=right;
	}
	
	
	
	

}
