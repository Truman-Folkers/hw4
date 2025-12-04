package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public class AndNode extends BinaryGateNode{
	
	/**
	 * constructor for the and gate node - calls the super constructor and assigns symbol to &
	 * @param left - the left child
	 * @param right - the right child
	 */
	public AndNode(Node left, Node right) {
		super(left, right);
		symbol = "&";
	}
	
	/**
	 * returns an int of the number returned by the gate, 1 if both children are 1, 0 else
	 */
	@Override
	public int evaluate() {
		return (left.evaluate() == 1 && right.evaluate() == 1) ? 1 : 0;
	}
}
