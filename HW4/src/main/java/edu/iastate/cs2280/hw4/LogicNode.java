package edu.iastate.cs2280.hw4;

public abstract class LogicNode extends Node {
	public Node left;
	public Node right;
	
	public LogicNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean hasChild() {
		return true;
	}
}
