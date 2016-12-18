package com.company;

public class Node {
	private int tag;
	private Node parent, left, right;
	
	public Node(int t, Node p, Node l, Node r) {
		tag = t;
		parent = p;
		left = l;
		right = r;
	}
	// Boolean
	public boolean isLeaf() {
		return (left == null && right == null);
	}
	
	public boolean isUnaryNode() {
		return (left == null ^ right == null);
	}
	
	// toString
	@Override
	public String toString() {
		if(isLeaf())
			return tag + "";
		return "(" + ((left != null) ? left : "*") + "," + ((right != null) ? right : "") + ")";
	}

	public static void prettyPrint(Node n, int level){
		if(n == null)
			return;
		for (int i = 0; i < level - 1; i++){
			System.out.print("  ");
		}
		if(n.isLeaf()){
			System.out.print("|--");
			System.out.print(n.tag + "\n");
		}
		else{
			System.out.print(n.tag + "\n");
			prettyPrint(n.left, level + 1);
			prettyPrint(n.right, level + 1);
		}
	}

	// Getters & Setters
	public int getWeight() {
		if (isLeaf())
			return 3;
		
		if (isUnaryNode())
			return 2;
		
		return 1;
	}
	
	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
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
}
