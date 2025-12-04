package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public class NotNode extends UnaryGateNode {
	
	/**
	 * constructor for not gate, assigns symbol and only has one child. 
	 * its the right child to help with printing structure because it will make the variable
	 * the "last" child even though its the only child
	 * @param right
	 */
	public NotNode(Node right) {
		super(right);
		symbol = "!";
	}
	
	/**
	 * evaulates to just the opposite of the current state
	 */
	@Override
	public int evaluate() {
		return (right.evaluate() == 0) ? 1 : 0;
	}
	
	

}
