package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public class XorNode extends BinaryGateNode{
	
	/**
	 * constructor for the xor gate node - calls the super constructor and assigns symbol to ^
	 * @param left - the left child
	 * @param right - the right child
	 */
	public XorNode(Node left, Node right) {
		super(left, right);
		symbol = "^";
	}
	
	/**
	 * evaluates the state output for xor gate, 1 if only one gate is 1, else 0 
	 */
	@Override
	public int evaluate() {
		return (left.evaluate() == 1 && right.evaluate() == 0) || (left.evaluate() == 0 && right.evaluate() == 1) ? 1 : 0;
	}
}
