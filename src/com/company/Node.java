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
		if (isLeaf())
			return "Leaf";
		return "Node("+left+","+right+")";
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
