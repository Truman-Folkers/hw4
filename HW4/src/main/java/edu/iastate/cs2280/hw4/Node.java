
package edu.iastate.cs2280.hw4;

public abstract class Node {
	
	public String symbol;
	public Node left;
	public Node right;
	
	
	public abstract int evaluate();
	
	public abstract boolean hasChild();
}
