package com.test1.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shivam
 *
 */
public class Node {
	/**
	 * list of children
	 */
	private List<Node> childList;

	/**
	 * value of node
	 */
	private int value;

	/**
	 * @return
	 */
	public List<Node> getChildList() {
		return childList;
	}

	/**
	 * @param childList
	 */
	public void setChildList(List<Node> childList) {
		this.childList = childList;
	}

	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Node constructor
	 * 
	 * @param val
	 */
	public Node(int val) {
		value = val;
		childList = new LinkedList<Node>();
	}
}
