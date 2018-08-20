package com.acme.algorithm;

public class LinkedListNode {

	public LinkedListNode next = null;
	public int data;
	
	public LinkedListNode(int value) {
		data = value;
	}
	
	public void add(LinkedListNode node) {
		next = node;
	}
	
	@Override
	public String toString() {
		return data+"";
	}
}
