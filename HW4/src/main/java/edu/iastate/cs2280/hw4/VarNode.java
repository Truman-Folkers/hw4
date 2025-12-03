package edu.iastate.cs2280.hw4;

public class VarNode extends Node {
	public int state;
	
	
	public VarNode(String name) {
		this.symbol = name;
	}
	
	public int evaluate() {
		return state;
	}
	
	public boolean hasChild() {
		return false;
	}

}
