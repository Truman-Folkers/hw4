package edu.iastate.cs2280.hw4;

public class NotNode extends UnaryGateNode {
	
	
	public NotNode(Node left) {
		super(left, null);
		symbol = "!";
	}
	
	@Override
	public int evaluate() {
		return (left.evaluate() == 0) ? 1 : 0;
	}
	
	

}
