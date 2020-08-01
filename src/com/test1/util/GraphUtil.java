package com.test1.util;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphUtil {

	/**
	 * root node
	 */
	private Node rootNode;

	/**
	 * class constructor
	 */
	public GraphUtil() {
		rootNode = null;
	}

	/**
	 * function to add node in the graph link it with parent ids provided
	 * 
	 * @param item
	 * @param parents
	 */
	public void addNode(int item, int... parents) {
		if (Arrays.binarySearch(parents, item) >= 0) {
			System.out.println("Child " + item + " can not be a part of parent " + Arrays.toString(parents));
			return;
		}

		Node newNode = new Node(item);
		for (int parent : parents) {
			Node node = search(parent);
			if (node != null) {
				node.getChildList().add(newNode);
			}
		}
	}

	/**
	 * 
	 * function to add root item in the graph
	 * 
	 * @param item
	 * @param children
	 * @return
	 */
	public void addRootNode(int item, int... children) {
		Node newNode = new Node(item);

		for (int child : children) {
			Node node = search(child);
			if (node != null) {
				newNode.getChildList().add(node);
			}
		}
		rootNode = newNode;
	}

	/**
	 * function to search if given item is present in graph or not.
	 * 
	 * @param item
	 * @return
	 */
	private Node search(int item) {
		if (rootNode == null) {
			System.out.println(item + " doesn't exists in the graph.");
			return null;
		}

		return searchNode(rootNode, item);
	}

	/**
	 * function to search if given item is a child of given node
	 * 
	 * @param root
	 * @param item
	 * @return
	 */
	private Node searchNode(Node root, int item) {
		if (root.getValue() == item)
			return root;

		for (Iterator<Node> i = root.getChildList().iterator(); i.hasNext();) {
			Node node = searchNode(i.next(), item);
			if (node != null) {
				return node;
			}
		}

		return null;
	}

	/**
	 * function to iterate over graph and display the results
	 */
	public void iterateOnGraph() {
		System.out.println("Starting path from root node " + rootNode.getValue());
		Deque<Integer> pathList = new LinkedList<Integer>();
		iterate(rootNode, pathList);
	}

	/**
	 * function to iterate over a given node
	 * 
	 * @param root
	 */
	private void iterate(Node root, Deque<Integer> pathList) {
		pathList.addLast(root.getValue());
		if (root.getChildList().size() == 0) {
			Iterator<Integer> i = pathList.iterator();
			while (i.hasNext()) {
				System.out.print(i.next() + "->");
			}
			pathList.removeLast();
			System.out.println("\n------");
			return;
		}

		for (Iterator<Node> i = root.getChildList().iterator(); i.hasNext();) {
			iterate(i.next(), pathList);
		}
		pathList.removeLast();
	}

	/**
	 * function to iterate from given node
	 * 
	 * @param item
	 */
	public void iterateFromGivenNode(int item) {
		System.out.println("Starting path from node " + item);
		Node node = search(item);
		if (node == null) {
			System.out.println(item + " doesn't exists in the graph");
			return;
		}

		Deque<Integer> pathList = new LinkedList<Integer>();
		iterate(node, pathList);
	}
}
