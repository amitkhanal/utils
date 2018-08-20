package com.acme.algorithm;

import java.util.HashSet;
import java.util.Set;

public class LinkedListUtils {

	public static void main(String[] args) {
		LinkedListNode head = setup();
/*		printLinkedNodes(head);
		System.out.println();
		deleteDupsWithoutBuffer(head);
		printLinkedNodes(head);
		
		head = setup();
		printLinkedNodes(head);
		System.out.println();
		deleteDupsWithBuffer(head);
		printLinkedNodes(head);*/

/*		head = setup();
		printLinkedNodes(head);
		System.out.println();
		LinkedListNode  newList = partitionList(head, 5);
		printLinkedNodes(newList);*/
		
		head = setup();
		printLinkedNodes(head);
		System.out.println();
		int size = getLizeOfList(head); //getSize(head);
		System.out.println("Size is - "+ size);
	}

	public static LinkedListNode setup() {
		LinkedListNode node = null;
		LinkedListNode head = null;
		for(int i=0; i< 10; i++) {
			 LinkedListNode newNode = new LinkedListNode(i);
			 if(node!=null) {
				 node.next = newNode;
				 node = newNode;
			 }else {
				 head = newNode;
				 node = newNode;
			 }
		}
		LinkedListNode newNode1 = new LinkedListNode(2);
		node.next = newNode1;
		node = newNode1;
		
		LinkedListNode newNode2 = new LinkedListNode(11);
		node.next = newNode2;
		node = newNode2;
				
		LinkedListNode newNode3 = new LinkedListNode(4);
		node.next = newNode3;
		node = newNode3;
		
	
		//deleteNode(newNode2);
		System.out.println();
		//printLinkedNodes(head);

		return head;
	}
	
	public static int getLizeOfList(LinkedListNode head) {
		int size = 0;
		
		if(head==null) {
			return 0;
		}
		
		LinkedListNode currentNode = head;
		LinkedListNode runner = currentNode.next.next;
		boolean odd = false;
		
		size++;
		while(currentNode!=null && runner!=null) {
			System.out.println("Runner is -> "+ runner);
			if(runner.next != null) {
				runner = runner.next.next;
				size++;
			}else {
				odd = true;
				runner = null;
			}
		}
		
		return odd? size*2+1:size*2;
	}
	
	
	public static int getSize(LinkedListNode head) {
		int size = 0;
		if(head == null) {
			return 0;
		}
		if(head.next == null) {
			return 1;
		}
		LinkedListNode currentNode = head;
		LinkedListNode runner = currentNode.next.next;
		size++;
		boolean odd = false;
		while(currentNode!=null && runner!=null) {
			System.out.println("Runner -> "+ runner);
			//currentNode = currentNode.next;
			
			if(runner.next!=null) {
				runner = runner.next.next;
				size++;
			}else {
				odd = true;
				runner = null;
			}
			currentNode = currentNode.next;
			
		}
		return size = odd? size*2+1:size*2;
		
	}
	
	public static void deleteDupsWithBuffer(LinkedListNode node) {
		Set<Integer> uniqueNodes = new HashSet<Integer>();
		LinkedListNode previousNode = null;
		while(node !=null) {
			if(!uniqueNodes.contains(node.data)) {
				uniqueNodes.add(node.data);
				previousNode = node;
			}else {
				previousNode.next = node.next;
			}
			node=node.next;
		}
	}
	
	public static void deleteDupsWithoutBuffer(LinkedListNode node) {
		while(node!=null) {
			LinkedListNode previous = node;
			LinkedListNode runner = node.next;

			int data = node.data;
			while(runner!=null) {
				if(runner.data == data) {
					previous.next = runner.next;
					previous = runner;
				}else {
					previous = runner;
				}
				runner = runner.next;
			}
			node = node.next;
		}
	}
	
	public static void deleteNode(LinkedListNode node) {
		if(node==null || node.next == null) {
			return;
		}
		node.data = node.next.data;
		node.next = node.next.next;
	}
	
	public static LinkedListNode partitionList(LinkedListNode node, int value) {
		LinkedListNode lowerNode = null, higherNode = null, lowerHead = null, higherHead = null;
		
		while(node!=null) {
			LinkedListNode newNode = new LinkedListNode(node.data);
			if(node.data < value) {
				if(lowerNode != null) {
					lowerNode.next = newNode;
				}else {
					lowerHead = newNode;
				}
				lowerNode = newNode;
			}else {
				if(higherNode!=null) {
					higherNode.next = newNode;
				}else {
					higherHead = newNode;
				}
				higherNode = newNode;
			}
			node = node.next;
		}
		lowerNode.next = higherHead;
		return lowerHead;
	}
	public static void printLinkedNodes(LinkedListNode node) {
		while(node!=null) {
			System.out.print(node.data);
			node = node.next;
			if(node!=null) {
				System.out.print("->");
			}
		}
	}
}
