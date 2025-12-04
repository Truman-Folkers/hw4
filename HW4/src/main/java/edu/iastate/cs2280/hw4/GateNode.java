package edu.iastate.cs2280.hw4;

/**
 * @author tfolkers
 */
public abstract class GateNode extends LogicNode {
	
	/**
	 * constructor for ABSTRACT gatenode, all decendants must be gates
	 * @param left - child
	 * @param right - child
	 */
	public GateNode(Node left, Node right) {
		super(left, right);
		
	}

}
