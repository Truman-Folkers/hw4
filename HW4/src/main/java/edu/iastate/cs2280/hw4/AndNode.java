package edu.iastate.cs2280.hw4;

public class AndNode extends BinaryGateNode{
	public Node left;
	public Node right;
	public String symbol;
	
	public AndNode(Node left, Node right) {
		super(left, right);
		symbol = "&";
	}
	
	@Override
	public int evaluate() {
		return (left.evaluate() == 1 && right.evaluate() == 1) ? 1 : 0;
	}
}
