package edu.iastate.cs2280.hw4;

public class NotNode extends UnaryGateNode {
	
	
	public NotNode(Node right) {
		super(null, right);
		symbol = "!";
	}
	
	@Override
	public int evaluate() {
		return (right.evaluate() == 0) ? 1 : 0;
	}
	
	

}
