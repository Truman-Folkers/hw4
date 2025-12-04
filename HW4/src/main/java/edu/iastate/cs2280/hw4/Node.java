
package edu.iastate.cs2280.hw4;
/**
 * @author tfolkers
 */
public abstract class Node {
	/**
	 * text symbol of the gate or variable
	 */
	public String symbol;
	
	/**
	 * left child of the node
	 */
	public Node left;
	/**
	 * right child of the node
	 */
	public Node right;
	
	/**
	 * all nodes must implement evaluate to tell what state is the output
	 * @return int state output
	 */
	public abstract int evaluate();
	
	/**
	 *  used to tell if at the end of the tree
	 * @return true or false if it has a child
	 */
	public abstract boolean hasChild();
}
