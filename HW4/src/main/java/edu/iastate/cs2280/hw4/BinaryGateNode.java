package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public abstract class BinaryGateNode extends GateNode {

	/**
	 * constructor for ABSTRACT binarygatenode, means all gates below have 2 children
	 * @param left - child
	 * @param right - child
	 */
	public BinaryGateNode(Node left, Node right) {
		super(left, right);
	}
	
	
}
