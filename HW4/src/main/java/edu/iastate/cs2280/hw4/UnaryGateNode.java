package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public abstract class UnaryGateNode extends GateNode {
	
	/**
	 * extends gate node, and means it only has one child (not gate)
	 * @param left - child
	 * @param right - child
	 */
	public UnaryGateNode(Node right) {
		super(null, right);
	}
	
	
	
}
