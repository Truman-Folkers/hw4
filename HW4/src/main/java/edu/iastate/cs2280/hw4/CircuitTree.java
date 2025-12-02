package edu.iastate.cs2280.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CircuitTree {
	private Node root;
	private ArrayList<VarNode> varMap;
	
	public CircuitTree(String circuitDescription) {
		Scanner sc = new Scanner(circuitDescription);
		
		varMap = new ArrayList<VarNode>();
		root = build(sc);
		
		
	}
	
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
	
	
	
	public void printStructure() {
		
		System.out.println("/-- " + root.symbol);
		System.out.println(buildOutput(root.left, "    "));
		System.out.println(buildOutput(root.right, "    "));
	}
	
	
	
	private Node build(Scanner sc) {
		String token = sc.next();
		
		
		if(token.equals("!")) {
			Node node = new NotNode(build(sc));
			
			return node;
		}
		
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
		
		else {
			 VarNode node = new VarNode(token);
		     varMap.add(node);  // remember this variable
		     return node;
		}
		
		return null;
	}
									
	private String buildOutput(Node curNode, String prefix){
		if(curNode == null) return "";
		
		String output = "";
		output += prefix;
		
		if(curNode.hasChild()) {
			output += "|-- ";
		}else {
			output += "/--";
		}
		
		output += "\n" + curNode.symbol;
		
		String newPrefix = prefix + (curNode.hasChild() ? "|   " : "    ");
		
		buildOutput(curNode.left, newPrefix);
		buildOutput(curNode.right, newPrefix);
		
		return output;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	//1) take a filename from cmd-line
	//2) print tree structure
	//3) print result for each input line
		
		
//		if (args.length == 0) {
//	        System.out.println("Usage: java edu.iastate.cs2280.hw4.CircuitTree <filename>");
//	        return;
//	    }
		
		Scanner fileInputScanner = new Scanner(System.in);
		
		System.out.println("Enter a filename");
		String fileName = fileInputScanner.next();
	
								//args[0]
	    File file = new File(fileName);
	    Scanner sc = new Scanner(file);
	    
	    
	    // Line 1 = circuit description
	    String circuitDescription = sc.nextLine();
	
	    // Build tree
	    CircuitTree tree = new CircuitTree(circuitDescription);
	
	    System.out.println("CIRCUIT STRUCTURE:");
	    tree.printStructure();
	
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
