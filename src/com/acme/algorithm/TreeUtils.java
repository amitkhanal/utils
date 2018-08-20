package com.acme.algorithm;

import java.util.Random;
import java.util.Stack;

public class TreeUtils {
	static RankNode root = null;
	
	public static void main(String[] args) {
		Random random = new Random();
		for(int i=0; i< 50; i++) {
			int randomInt = random.nextInt(100);
			System.out.print(randomInt + ",");
			track(randomInt);
		}
		System.out.println();
		System.out.println(" Rank is " + root.getRank(15));
		
		int length = 20;
		int[] sortedArray = new int[length];
		for(int i=0;i<length; i++) {
			sortedArray[i] = i;
		}
		TreeNode root = createBinaryTreeFromSortedArray(sortedArray);
		System.out.println("\n Recursive");
		printTreeViaRecursivePreOrderDFS(root);
		System.out.println("\n Stack");
		printTreeViaPreOrderDFS(root);
		
		root = createBinaryTreeFromSortedArray(sortedArray);
		System.out.println();
		System.out.println("Tree is balanced - "+ isTreeBalanced(root));
	}
	
	public static void printTreeViaPreOrderDFS(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		
		TreeNode currentNode = root;
		while(currentNode!=null) {
			nodes.push(currentNode);
			currentNode = currentNode.left;
		}
		
		while(!nodes.isEmpty()) {
			TreeNode node = nodes.pop();
			System.out.print(node.data + ",");
			
			if(node.right!=null) {
				node = node.right;
				while(node !=null) {
					nodes.push(node);
					node = node.left;
				}
			}
		}
		
		
	}
	
	public static void printTreeViaRecursivePreOrderDFS(TreeNode root) {
		if(root == null) {
			return;
		}
			printTreeViaRecursivePreOrderDFS(root.left);
			System.out.print(root.data + ":");
			printTreeViaRecursivePreOrderDFS(root.right);
	}
	
	public static void track(int n) {
		if(root == null) {
			root = new RankNode(n);
		}else {
			root.insert(n);
		}
	}
	
	
	public static TreeNode createBinaryTreeFromSortedArray(int[] array) {
		TreeNode root = createBST(array, 0, array.length);
		return root;
	}

	private static TreeNode createBST(int[] array, int start, int end) {
		if(end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode midNode = new TreeNode(mid);
		midNode.left = createBST(array, start,mid-1);
		midNode.right = createBST(array, mid+1,  end);
		return midNode;
	}
	
	private static TreeNode delete(TreeNode root, int value) {
		
		if(root == null) {
			return root;
		}
		
		if(value < root.data) {
			delete(root.left, value);
		}else if(value > root.data){
			delete(root.right, value);
		}else {
			if(root.left == null) {
				return root.right;
			}if(root.right == null) {
				return root.left;
			}
			
			root.data = getMin(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}
	
	private static int getMin(TreeNode root) {
		int minValue = root.data;
		
		while(root.left!=null) {
			minValue = root.left.data;
			root = root.left;
		}
		return minValue;
	}
	
	static TreeNode prev = null;
	
	private static boolean isTreeBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		if(!isTreeBalanced(root.left)) {
			return false;
		}
		
		if(prev !=null && prev.data >= root.data) {
			return false;
		}
		prev = root;
		return isTreeBalanced(root.right);
	}
	
	public static TreeNode createBSTFromSortedArray(int[] array) {
		if(array == null || array.length==0) {
			return null;
		}
		return createBST(array, 0, array.length);
	}
	
	/*public static TreeNode createBST(int[] array, int start, int end) {
		if(end < start) {
			return null;
		}
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(mid);
		
		node.left = createBST(array, start, mid-1);
		node.right = createBST(array, mid+1, end);
		return  node;
	}*/
}
