package edu.iastate.cs2280.hw4;
/**
 * @author tfolkers
 */
public class VarNode extends Node {
	/**
	 * state of the variable, 0 or 1 (or both if its a qubit haha)
	 */
	public int state;
	
	/**
	 * constructor for variable node, not a logic node
	 * @param name - name of the variable which will be attached to the symbol
	 */
	public VarNode(String name) {
		this.symbol = name;
	}
	/**
	 * final step in evaluate recursion, returns state of the variable
	 */
	public int evaluate() {
		return state;
	}
	/**
	 * variables are leaf nodes, so HasChild returns false
	 */
	public boolean hasChild() {
		return false;
	}
	
	//just to clarify, my program does not allow for qubits

}
