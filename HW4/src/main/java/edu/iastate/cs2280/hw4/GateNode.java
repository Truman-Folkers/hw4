package edu.iastate.cs2280.hw4;

public abstract class GateNode extends LogicNode {
	public Node left;
	public Node right;
	
	public GateNode(Node left, Node right) {
		super(left, right);
		
	}

}
