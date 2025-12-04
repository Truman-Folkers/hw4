package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public abstract class LogicNode extends Node {
	
	/**
	 * constructor for ABSTRACT logicnode, all gates below must be using logic and not a variable
	 * @param left
	 *  - child
	 * @param right - child
	 */
	public LogicNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
	/**
	 * returns true because all gates below must be logic , which includes children
	 */
	public boolean hasChild() {
		return true;
	}
}
