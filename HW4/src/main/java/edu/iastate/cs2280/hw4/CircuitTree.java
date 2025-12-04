package edu.iastate.cs2280.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author tfolkers
 */
public class CircuitTree {
	/**
	 * The root node, the only thing we have to story for the entire tree
	 */
	private Node root;
	/**
	 * map of variables to keep track of for the evaulate method
	 */
	private ArrayList<VarNode> varMap;
	
	/**
	 * constructor that initializes scanner, the varmap, and builds the tree off of the root
	 * @param circuitDescription - the txt desc of the circuit
	 */
	public CircuitTree(String circuitDescription) {
		Scanner sc = new Scanner(circuitDescription);
		
		varMap = new ArrayList<VarNode>();
		root = build(sc);
		
		
	}
	
	/**
	 * evaluates the tree's output recursively with each node's evaluate method which returns an int
	 * @param inputLine - the line of values to take that represent the variable's states
	 */
	public void evaluate(String inputLine) {
		Scanner sc = new Scanner(inputLine);
		
		while(sc.hasNext()) {
			String var = sc.next();
			String[] parts = var.split("=");
			
			String varName = parts[0];
			int varVal = Integer.parseInt(parts[1]);
			
			for(VarNode v : varMap) {
				if(v.symbol.equals(varName)) {
					v.state = varVal;
				}
			}
		}
		int result = root.evaluate();

	    System.out.println(inputLine + " -> " + result);
	}
	
	
	/**
	 * The method for users/main method to call to print the circuit structure
	 * first prints the root, then the left of the list, then the right
	 */
	public void printStructure() {
		
		System.out.println("CIRCUIT STRUCTURE:");
		System.out.println("\\-- " + root.symbol);
		buildOutput(root.left, "    ", true);
		buildOutput(root.right, "    ", false);
	}
	
	/**
	 * Builds and prints the circuit structure output in directory style implementation
	 * @param curNode
	 * @param prefix
	 * @param isLeftChild
	 */
	private void buildOutput(Node curNode, String prefix, boolean isLeftChild){
		if (curNode == null) return;

	    // add first prefix
	    System.out.print(prefix);
	    System.out.print(isLeftChild ? "|-- " : "\\-- ");
	    System.out.println(curNode.symbol);

	    //make new prefix
	    String newPrefix = prefix + (isLeftChild ? "|   " : "    ");

	    // recursively print children
	    if (curNode.left != null)
	        buildOutput(curNode.left, newPrefix, true);

	    if (curNode.right != null)
	        buildOutput(curNode.right, newPrefix, false);

	}
	
	/**
	 * Builds the tree recursively and returns the root node
	 * @param sc - scanner of the input file first line containing symbols
	 * @return the root node
	 */
	private Node build(Scanner sc) {
		String token = sc.next();
		
		//If its a not gate return a node node and recursively do the rest of the list
		if(token.equals("!")) {
			Node node = new NotNode(build(sc));
			
			return node;
		}
		//Same with other gates
		else if(token.equals("&") || token.equals("|") || token.equals("^")) {
			switch(token) {
				case "&":
					Node andNode = new AndNode(build(sc), build(sc));
					
					return andNode;
					
				case "|":
					Node orNode = new OrNode(build(sc), build(sc));

					return orNode;
					
				case "^":
					Node xorNode = new XorNode(build(sc), build(sc));
					
					return xorNode;
					
			}
		}
		//Do a varnode and add to the varmap arraylist
		else {
			 VarNode node = new VarNode(token);
		     varMap.add(node);  // remember this variable
		     return node;
		}
		
		return null;
	}
									
	
	/**
	 * The main method to run the program
	 * @param args takes the filename
	 * @throws FileNotFoundException in case of a wrong filename
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		if (args.length == 0) {
	        System.out.println("Usage: java edu.iastate.cs2280.hw4.CircuitTree <filename>");
	        return;
	    }
		
	
		//1) take a filename from cmd-line
	    File file = new File(args[0]);
	    Scanner sc = new Scanner(file);
	    
	    
	    // Line 1 = circuit description
	    String circuitDescription = sc.nextLine();
	
	    //Build tree
	    CircuitTree tree = new CircuitTree(circuitDescription);
	
	  //2) print tree structure
	    tree.printStructure();
	
	  //3) print result for each input line
	    System.out.println("\nEVALUATION:");
	
	    // Remaining lines = inputs
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine().trim();
	        if (!line.isEmpty())
	            tree.evaluate(line);
	    }
	
	    sc.close();
	}
}
