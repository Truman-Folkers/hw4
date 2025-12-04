package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public class OrNode extends BinaryGateNode{
	

	/**
	 * constructor for the or gate node - calls the super constructor and assigns symbol to |
	 * @param left - the left child
	 * @param right - the right child
	 */
	public OrNode(Node left, Node right) {
		super(left, right);
		symbol = "|";
	}
	
	/**
	 * returns 1 if at least one child is 1 else 0, the evaluate method for the or gate
	 */
	@Override
	public int evaluate() {
		return (left.evaluate() == 1) || (right.evaluate() == 1) ? 1 : 0;
	}
}
