package com.acme.algorithm;

import java.util.LinkedList;
import java.util.Stack;

public class GraphUtils {

	public static void main(String[] args) {
		
	}
	
	public static GraphNode performDFS(GraphNode root, int value) {
		
		if(root == null) {
			return null;
		}
		if(root.data == value) {
			return root;
		}
		root.visited = true;
		for(GraphNode node: root.adjacentNodes) {
			if(!node.visited) {
				performDFS(node, value);
			}
		}
		return null;
	}
	
	public static GraphNode performDFSWithStack(GraphNode root, int value) {
		if(root == null) {
			return null;
		}
		Stack<GraphNode> nodeStack = new Stack<>();
		root.visited = true;
		nodeStack.push(root);
		
		while(!nodeStack.isEmpty()) {
			GraphNode node = nodeStack.pop();
			if(node.data == value) {
				return node;
			}
			
			for(GraphNode n: node.adjacentNodes) {
				if(!n.visited) {
					nodeStack.push(n);
					n.visited=true;
				}
			}
		}
		return null;
	}
	
	public static GraphNode performBFS(GraphNode root, int value) {
		
		if(root == null) {
			return null;
		}
		
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			GraphNode node = queue.getFirst();
			if(node.data == value) {
				return node;
			}
			for(GraphNode n: node.adjacentNodes) {
				if(!n.visited) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
		return null;
	}
}
