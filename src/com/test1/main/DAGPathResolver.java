package com.test1.main;

import com.test1.util.GraphUtil;

/**
 * @author Shivam
 *
 */
public class DAGPathResolver {
	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GraphUtil graphObj = new GraphUtil();

		// adding root node
		graphObj.addRootNode(1);

		// adding some nodes
		// first argument is item value, other arguments define its parent.
		graphObj.addNode(2, 2);
		graphObj.addNode(3, 1);
		graphObj.addNode(1, 3);
		graphObj.addNode(4, 1);
		graphObj.addNode(5, 1);
		graphObj.addNode(6, 2, 3);
		graphObj.addNode(7, 3, 4);
		graphObj.addNode(8, 4, 5);

		// adding a new root node
		// first argument is item value, other arguments define its children
		graphObj.addRootNode(10, 1);

		// display result starting from root node
		graphObj.iterateOnGraph();

		// display result starting from given node
		graphObj.iterateFromGivenNode(3);
	}
}
