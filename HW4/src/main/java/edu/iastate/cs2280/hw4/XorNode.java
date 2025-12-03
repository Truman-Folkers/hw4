package edu.iastate.cs2280.hw4;

public class XorNode extends BinaryGateNode{
	
	
	public XorNode(Node left, Node right) {
		super(left, right);
		symbol = "^";
	}
	
	@Override
	public int evaluate() {
		return (left.evaluate() == 1 && right.evaluate() == 0) || (left.evaluate() == 0 && right.evaluate() == 1) ? 1 : 0;
	}
}
